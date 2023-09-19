import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void RemoveProductTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(123, "Самокат", 7_384);
        Product product2 = new Product(2, "Мейн-Кун", 87_384);
        Product product3 = new Product(234, "Джинсы Сталоне", 3_333_987);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveProductNotExistTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(123, "Самокат", 7_384);
        Product product2 = new Product(2, "Мейн-Кун", 87_384);
        Product product3 = new Product(234, "Джинсы Сталоне", 3_333_987);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(23423));
    }

    @Test
    public void addedProductTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(123, "Самокат", 7_384);
        Product product2 = new Product(2, "Мейн-Кун", 87_384);
        Product product3 = new Product(234, "Джинсы Сталоне", 3_333_987);
        Product product4 = new Product(33, "Кросовки Арни", 987);
        repo.added(product1);
        repo.added(product2);
        repo.added(product3);
        repo.added(product4);
        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addedExistingProductTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(123, "Самокат", 7_384);
        Product product2 = new Product(2, "Мейн-Кун", 87_384);
        Product product3 = new Product(234, "Джинсы Сталоне", 3_333_987);
        Product product4 = new Product(33, "Кросовки Арни", 987);
        repo.added(product1);
        repo.added(product2);
        repo.added(product3);
        repo.added(product4);
        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.added(product4));
    }
}
