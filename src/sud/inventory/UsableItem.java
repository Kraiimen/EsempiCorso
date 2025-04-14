package sud.inventory;

import sud.entity.Entity;

public interface UsableItem {
    public abstract void use(Entity target);
}
