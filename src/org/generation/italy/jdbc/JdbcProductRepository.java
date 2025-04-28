package org.generation.italy.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcProductRepository implements ProductRepository {

    //STATE
    private static final String INSERT_PRODUCT = """
            INSERT INTO products
            (productname, supplierid, categoryid, unitprice, discontinued)
            VALUES(?,?,?,?,?)
            """;
    private static final String UPDATE_PRODUCT = """
            UPDATE products
            SET productname = ?, supplierid = ?, categoryid = ?, unitprice = ?, discontinued = ?
            WHERE productid = ?;
            """;

    //Query con metodo collage (ABOMINIO)
    private static final String DELECT_PRODUCT = """
            DELETE FROM products
            WHERE productid = 
            """; //I 3 doppi apici indicano una query
    //Query con metodo esatto
    private static final String FIND_BY_ID = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued 
            FROM products
            WHERE productid = ?
            """; // Il ? rappresenta un buco che sarà sostituito da un parametro
    private static final String FIND_ALL = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued
            FROM products
            """;
    private static final String FIND_BY_NAME_LIKE = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued
            FROM products
            WHERE productname LIKE ?
            """;
    private Connection con;


    //COSTRUCTORS
    public JdbcProductRepository(Connection con) {
        this.con = con;
    }

    //METHODS
    @Override
    public Product create(Product newProduct) throws DataException { // Torna un product con id nuovo settato
        try(PreparedStatement st = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, newProduct.getProductname()); //1 rappresenta il primo punto interrogativo
            st.setInt(2, newProduct.getSupplierid()); // 2 = secondo ?...
            st.setInt(3, newProduct.getCategoryid());
            st.setDouble(4, newProduct.getUnitprice());
            st.setInt(5, newProduct.getDiscontinued());
            st.executeUpdate(); //Ignoro l'intero che mi ritorna, perché o funziona e sarà 1 o crasha il metodo
            // Ora devo tornare il prodotto con la productid che verrà settata dal DB
            //Se faccio return newProduct; lo torno esattamente come ci è stato dato, con id 0
            //Solo per ora faccio return newProduct, ma da verificare come si fa
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()) {
            newProduct.setProductId(rs.getInt(), "productid");
            }
            return newProduct;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Product updatedProduct) throws DataException {
        try(PreparedStatement st = con.prepareStatement(UPDATE_PRODUCT)) {
            st.setString(1, updatedProduct.getProductname()); //1 rappresenta il primo punto interrogativo
            st.setInt(2, updatedProduct.getSupplierid()); // 2 = secondo ?...
            st.setInt(3, updatedProduct.getCategoryid());
            st.setDouble(4, updatedProduct.getUnitprice());
            st.setInt(5, updatedProduct.getDiscontinued());
            st.setInt(6, updatedProduct.getProductid());

            int rows = st.executeUpdate();
            return rows == 1; // Mi torna true se l'aggiornamento è avvenuto, quindi l'executeUpdate mi torna 1

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    //ABOMINIO! Vedi giù
    @Override
    public boolean delete(int id) throws DataException{
        try(Statement st = con.createStatement()) {
            int rows = st.executeUpdate(DELECT_PRODUCT + id); //Con executeUpdate eseguo la query e gli passo l'id da considerare
            //Per fare una delete non serve una query, perché la query mi ritorna qualcosa, basta un update. executeUpdate mi torna un int, il numero di linee cambiate (?controlla)
            //In questo caso executeUpdate può tornarmi solo 0 o 1, perché sto facendo un delete passandogli un id
            return rows == 1; //Torna 1 se la cancellazione va a buon fine
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }
    //Questo metodo su è un abominio, perché è una query tramite collage di Stringhe
    //e questo ci espone a SQL Injection e ai vari svantaggi di questa metodologia

    @Override
    public Optional<Product> findById(int id) throws DataException {
        try(PreparedStatement st = con.prepareStatement(FIND_BY_ID)) {
            st.setInt(1, id); //1 rappresenta il punto interrogativo, se ce ne fossero di più corrisponderebbero a 2, 3, ecc
            try(ResultSet rs = st.executeQuery()) {
                //Non ci sta catch, il try with resources qui serve solo a chiudere il ResultSet
                if (rs.next()) { //If e non while perché gli sto passando un id, lavoro con solo 1 dato
                    Product p = new Product(rs.getInt("productid"),
                                            rs.getString("productname"),
                                            rs.getInt("supplierid"),
                                            rs.getInt("categoryid"),
                                            rs.getDouble("unitprice"),
                                            rs.getInt("discontinued"));
                    return Optional.of(p);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> findAll() throws DataException {
        List<Product> allProducts = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(FIND_ALL)) { // In questo caso non serve un try with resources per il ResultSet perché non sto usando
             while(rs.next()) {
                 Product p = fromResultSet(rs);
                 allProducts.add(p);
             }
            return allProducts;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> findByNameLike(String namePart) throws DataException {
        List<Product> productByName = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(FIND_BY_NAME_LIKE)) {
            ps.setString(1, "%" + namePart + "%"); //In questo modo devo passargli solo la stringa, i %% per trovarla in SQL è già implicito del metodo
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Product p = fromResultSet(rs);
                    productByName.add(p);
                }
                return productByName;
            }

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    private Product fromResultSet(ResultSet rs) throws SQLException {
        Product p = new Product(rs.getInt("productid"),
                rs.getString("productname"),
                rs.getInt("supplierid"),
                rs.getInt("categoryid"),
                rs.getDouble("unitprice"),
                rs.getInt("discontinued")
        );
        return p;
    }
}

