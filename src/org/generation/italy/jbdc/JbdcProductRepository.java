package org.generation.italy.jbdc;

import java.sql.*;
import java.util.List;

public class JbdcProductRepository implements ProductRepository{

    private Connection con;
    private static final String DELETE_PRODUCT = """
            DELETE FROM products
            WHERE productid = 
            """;
    private static final String FIND_BY_ID = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued
            FROM products
            WHERE productid = ?
            """;

    public JbdcProductRepository(Connection con){
        this.con = con;
    }

    @Override
    public Product create(Product newProduct) {
        return null;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) throws DataException{
        try(Statement st = con.createStatement()){
            int lines = st.executeUpdate(DELETE_PRODUCT + id);
            return lines == 1;
        } catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }

        // motivi per cui queste righe di codice sono un abominio:
        // 1 creare una query complessa con collage di Stringhe è scomodo e caotico
        // 2 I parametri nella String originaria sono dati che vengono dall'utente
        //   però lui lei potrebbe dire "martello: DELETE FROM products" e finisce che manda in esecuzione un sql
        //   che non ho deciso io. è una tecnica di hacking che si chiama SQL injection
        // 3 I database creano dei piani di esecuzione con le loro query. Con queste righe avrei lo stesso piano di esecuzione
        //   molte volte, che è una perdita di tempo e sforzo del compilatore.
        // SOLUZIONE:
        // passare una query con n buchi e n parametri
    }

    @Override
    public Product findById(int id) {
        try(PreparedStatement st = con.prepareStatement(FIND_BY_ID)){
            st.setInt(1,id);
            try(ResultSet rs = st.executeQuery()){
                if(rs.next())
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public List<Product> findByNameLike(String namePart) {
        return List.of();
    }
}
