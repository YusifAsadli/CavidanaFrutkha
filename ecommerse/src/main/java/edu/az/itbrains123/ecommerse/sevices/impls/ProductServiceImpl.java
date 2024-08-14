package edu.az.itbrains123.ecommerse.sevices.impls;

import edu.az.itbrains123.ecommerse.dtos.product.ProductDealDto;
import edu.az.itbrains123.ecommerse.dtos.product.ProductDetailDto;
import edu.az.itbrains123.ecommerse.dtos.product.ProductHomeDto;
import edu.az.itbrains123.ecommerse.dtos.product.ProductRelatedDto;
import edu.az.itbrains123.ecommerse.models.Product;
import edu.az.itbrains123.ecommerse.repositories.ProductRepository;
import edu.az.itbrains123.ecommerse.sevices.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ProductHomeDto> getHomeProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductHomeDto> result= products.stream().limit(3).map(x->modelMapper.map(x,ProductHomeDto.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public ProductDetailDto getProductDetail(Long id) {
        Product product=productRepository.findById(id).orElseThrow();
        ProductDetailDto result=modelMapper.map(product,ProductDetailDto.class);
        return result;
    }

    @Override
    public List<ProductRelatedDto> getRelatedProducts(Long id) {
        Product findProduct=productRepository.findById(id).orElseThrow();
        List<Product> products = productRepository.findByCategoryId(findProduct.getCategory().getId());
        List<ProductRelatedDto> result= products.stream().filter(x->x.getCategory().getId() == findProduct.getCategory().getId()).map(x->modelMapper.map(x,ProductRelatedDto.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public ProductDealDto getProductDeal() {
        Product product=productRepository.findByFeaturedTrue();
        ProductDealDto result =modelMapper.map(product,ProductDealDto.class);
        float percent=result.getDiscountPrice() * 100 / result.getPrice();
        result.setDiscountPercent((float)Math.round(percent));
        return result;
    }


    private List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
//        products.add(new Product(1L, "Apple", 12.5F, 100.00F, 1L,
//                "Crisp and juicy, our apples are a perfect blend of sweetness and tartness. Great for snacking, baking, or adding to salads. Packed with vitamins and fiber, these apples are not only delicious but also a healthy choice for any time of day."));
//
//        products.add(new Product(2L, "Banana", 10.0F, 150.00F, 1L,
//                "Our bananas are rich in potassium and provide a quick energy boost. Perfect for a healthy snack, smoothies, or baking. They are naturally sweet, making them a favorite among children and adults alike. Peel and enjoy the creamy, smooth texture."));
//
//        products.add(new Product(3L, "Mango", 20.0F, 50.00F, 1L,
//                "Our mangoes are succulent and sweet, with a rich, tropical flavor. Perfect for enjoying on their own, in smoothies, or as a topping for desserts. They are high in vitamins A and C, making them a nutritious and delicious addition to your diet."));
//
//        products.add(new Product(4L, "Peach", 22.0F, 90.00F, 1L,
//                "Juicy and aromatic, our peaches are a summer favorite. Perfect for eating fresh, baking into pies, or grilling. Rich in vitamins A and C, these peaches are not only delicious but also offer numerous health benefits. Enjoy their sweet, succulent taste."));
//
//        products.add(new Product(5L, "Pineapple", 30.0F, 40.00F, 1L,
//                "Our pineapples are sweet and tangy, with a tropical flavor that’s perfect for snacking, grilling, or adding to recipes. High in vitamin C and bromelain, they support digestion and boost immunity. Enjoy the fresh, juicy goodness in every bite."));
//
//        products.add(new Product(6L, "Papaya", 18.0F, 70.00F, 1L,
//                "Our papayas are sweet and buttery, perfect for enjoying fresh, in smoothies, or as part of a fruit salad. High in vitamin C and digestive enzymes, they support digestion and provide a nutritious, delicious treat."));
//
//        products.add(new Product(7L, "Plum", 15.0F, 80.00F, 1L,
//                "Our plums are sweet and tart, with a juicy, succulent texture. Perfect for snacking, baking, or adding to salads. High in vitamins C and K, they are a tasty and healthy choice for any time of day."));
//
//        products.add(new Product(8L, "Pear", 12.0F, 95.00F, 1L,
//                "Our pears are sweet and juicy, with a smooth, buttery texture. Perfect for snacking, baking, or adding to salads. High in fiber and vitamin C, they are a delicious and nutritious choice for any time of day."));
//
//        products.add(new Product(9L, "Cherry", 25.0F, 60.00F, 1L,
//                "Our cherries are sweet and juicy, with a vibrant, rich flavor. Perfect for snacking, baking, or adding to desserts. High in antioxidants and vitamins, they are a delicious and nutritious treat."));
//
//        products.add(new Product(10L, "Apricot", 18.0F, 75.00F, 1L,
//                "Our apricots are sweet and tangy, with a smooth, juicy texture. Perfect for snacking, baking, or adding to salads. High in vitamins A and C, they are a tasty and healthy choice for any time of day."));
//
//        products.add(new Product(11L, "Guava", 16.0F, 85.00F, 1L,
//                "Our guavas are sweet and aromatic, with a tropical flavor that’s perfect for snacking, blending into smoothies, or adding to desserts. High in vitamin C and fiber, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(12L, "Pomegranate", 22.0F, 65.00F, 1L,
//                "Our pomegranates are rich in flavor and packed with juicy seeds. Perfect for snacking, adding to salads, or juicing. High in antioxidants and vitamins, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(13L, "Avocado", 25.0F, 50.00F, 1L,
//                "Our avocados are creamy and rich, perfect for making guacamole, adding to salads, or enjoying on toast. High in healthy fats and vitamins, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(14L, "Fig", 20.0F, 70.00F, 1L,
//                "Our figs are sweet and succulent, with a rich, jammy texture. Perfect for snacking, baking, or adding to salads. High in fiber and vitamins, they are a delicious and nutritious choice."));
//
//        products.add(new Product(15L, "Cantaloupe", 28.0F, 40.00F, 1L,
//                "Our cantaloupes are sweet and juicy, with a refreshing, mild flavor. Perfect for snacking, adding to fruit salads, or blending into smoothies. High in vitamins A and C, they are a healthy and delicious choice."));
//
//        // Berries
//        products.add(new Product(16L, "Strawberry", 25.0F, 60.00F, 2L,
//                "Fresh and vibrant, our strawberries are bursting with flavor. Perfect for snacking, adding to desserts, or blending into smoothies. These berries are rich in antioxidants and vitamin C, offering a sweet and healthy treat that’s hard to resist."));
//
//        products.add(new Product(17L, "Blueberry", 15.0F, 45.00F, 2L,
//                "Tiny but mighty, our blueberries are bursting with flavor and nutrients. Perfect for snacking, adding to cereals, or baking into muffins. High in antioxidants and vitamins, they are a superfood that supports brain health and boosts immunity."));
//
//        products.add(new Product(18L, "Raspberry", 18.0F, 55.00F, 2L,
//                "Delicate and sweet, our raspberries are perfect for snacking, desserts, or adding to salads. Rich in antioxidants and fiber, they offer numerous health benefits. Enjoy their bright, tangy flavor and vibrant color in every bite."));
//
//        products.add(new Product(19L, "Blackberry", 17.0F, 65.00F, 2L,
//                "Our blackberries are juicy and flavorful, with a deep, rich color. Perfect for snacking, baking, or making jams. High in vitamins C and K, they are a nutritious and delicious addition to your diet. Enjoy their natural sweetness and health benefits."));
//
//        products.add(new Product(20L, "Cranberry", 20.0F, 75.00F, 2L,
//                "Tart and tangy, our cranberries are perfect for adding to salads, baking, or making homemade sauces. High in antioxidants and vitamin C, they support urinary health and boost immunity. Enjoy their unique flavor and numerous health benefits."));
//
//        products.add(new Product(21L, "Goji Berry", 30.0F, 40.00F, 2L,
//                "Our goji berries are sweet and tart, with a unique flavor that’s perfect for snacking, adding to cereals, or blending into smoothies. High in antioxidants and vitamins, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(22L, "Acai Berry", 35.0F, 30.00F, 2L,
//                "Our acai berries are rich and flavorful, perfect for adding to smoothies, bowls, or desserts. High in antioxidants and healthy fats, they are a superfood that supports overall health and provides a delicious, nutritious boost."));
//
//        products.add(new Product(23L, "Elderberry", 25.0F, 50.00F, 2L,
//                "Our elderberries are small but powerful, with a rich, tart flavor. Perfect for making syrups, jams, or teas. High in antioxidants and vitamins, they support immune health and offer numerous benefits. Enjoy their unique taste and health advantages."));
//
//        products.add(new Product(24L, "Mulberry", 18.0F, 55.00F, 2L,
//                "Our mulberries are sweet and juicy, with a unique, slightly tart flavor. Perfect for snacking, adding to cereals, or baking into desserts. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(25L, "Gooseberry", 15.0F, 60.00F, 2L,
//                "Our gooseberries are tangy and slightly sweet, perfect for snacking, baking, or adding to salads. High in vitamins and antioxidants, they offer numerous health benefits and a unique, delicious flavor."));
//
//        // Citrus Fruits
//        products.add(new Product(26L, "Orange", 8.5F, 200.00F, 3L,
//                "Bursting with Vitamin C, our oranges are juicy and refreshing. Enjoy them as a snack, in a fruit salad, or freshly squeezed into juice. The perfect combination of tangy and sweet, these oranges are a delicious way to support your immune system."));
//
//        products.add(new Product(27L, "Lemon", 5.0F, 120.00F, 3L,
//                "Bright and tangy, our lemons are perfect for adding flavor to dishes, making lemonade, or using in desserts. High in vitamin C, they support immune health and add a refreshing zest to any recipe. Enjoy the fresh, vibrant taste of our lemons."));
//
//        products.add(new Product(28L, "Lime", 4.5F, 130.00F, 3L,
//                "Zesty and tart, our limes are perfect for adding a burst of flavor to dishes, drinks, and desserts. High in vitamin C, they support immune health and enhance the taste of any recipe. Enjoy the fresh, tangy goodness of our limes."));
//
//        products.add(new Product(29L, "Grapefruit", 6.0F, 110.00F, 3L,
//                "Our grapefruits are tangy and slightly sweet, perfect for breakfast, salads, or juicing. High in vitamins A and C, they boost immunity and support skin health. Enjoy the refreshing and tart flavor of our fresh grapefruits."));
//
//        products.add(new Product(30L, "Mandarin", 7.0F, 140.00F, 3L,
//                "Our mandarins are sweet, easy to peel, and perfect for snacking. Packed with vitamin C and antioxidants, they are great for boosting immunity and overall health. Enjoy the juicy, vibrant taste of our fresh mandarins."));
//
//        products.add(new Product(31L, "Tangerine", 6.5F, 130.00F, 3L,
//                "Our tangerines are sweet and tangy, perfect for snacking, adding to salads, or juicing. High in vitamin C and antioxidants, they offer numerous health benefits and a delicious taste. Enjoy their easy-to-peel convenience and vibrant flavor."));
//
//        products.add(new Product(32L, "Clementine", 6.0F, 135.00F, 3L,
//                "Our clementines are sweet and easy to peel, perfect for snacking, adding to fruit salads, or juicing. High in vitamin C and antioxidants, they support immune health and provide a delicious, nutritious treat. Enjoy their fresh, juicy flavor."));
//
//        products.add(new Product(33L, "Pomelo", 9.0F, 100.00F, 3L,
//                "Our pomelos are sweet and tangy, with a juicy, refreshing flavor. Perfect for snacking, adding to salads, or juicing. High in vitamins A and C, they offer numerous health benefits and a delicious taste. Enjoy their unique, citrusy goodness."));
//
//        products.add(new Product(34L, "Blood Orange", 8.0F, 110.00F, 3L,
//                "Our blood oranges are sweet and slightly tart, with a vibrant red flesh. Perfect for snacking, adding to salads, or juicing. High in vitamin C and antioxidants, they offer numerous health benefits and a delicious, unique flavor."));
//
//        products.add(new Product(35L, "Yuzu", 10.0F, 90.00F, 3L,
//                "Our yuzu are aromatic and tangy, with a unique citrus flavor. Perfect for adding zest to dishes, making drinks, or using in desserts. High in vitamin C and antioxidants, they offer numerous health benefits and a refreshing taste. Enjoy the exotic flavor of yuzu."));
//
//        // Adding 25 more products to make it 60 in total
//
//        // Fruits
//        products.add(new Product(36L, "Durian", 50.0F, 20.00F, 1L,
//                "Our durians are creamy and rich, with a unique, complex flavor. Perfect for adventurous eaters, they are high in vitamins and healthy fats. Enjoy the bold taste and numerous health benefits of this tropical fruit."));
//
//        products.add(new Product(37L, "Lychee", 28.0F, 45.00F, 1L,
//                "Our lychees are sweet and aromatic, with a juicy, tender texture. Perfect for snacking, adding to fruit salads, or blending into drinks. High in vitamin C and antioxidants, they offer a delicious and nutritious treat."));
//
//        products.add(new Product(38L, "Starfruit", 24.0F, 50.00F, 1L,
//                "Our starfruits are crisp and tangy, with a unique star shape. Perfect for snacking, adding to salads, or juicing. High in vitamin C and antioxidants, they offer numerous health benefits and a delicious taste. Enjoy their refreshing, tropical flavor."));
//
//        products.add(new Product(39L, "Passionfruit", 32.0F, 35.00F, 1L,
//                "Our passionfruits are sweet and tangy, with a vibrant, tropical flavor. Perfect for snacking, adding to desserts, or blending into drinks. High in vitamins A and C, they offer numerous health benefits and a delicious taste. Enjoy the exotic flavor of passionfruit."));
//
//        products.add(new Product(40L, "Dragonfruit", 35.0F, 40.00F, 1L,
//                "Our dragonfruits are sweet and juicy, with a unique, vibrant appearance. Perfect for snacking, adding to fruit salads, or blending into smoothies. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(41L, "Rambutan", 27.0F, 45.00F, 1L,
//                "Our rambutans are sweet and juicy, with a unique, hairy exterior. Perfect for snacking, adding to fruit salads, or blending into drinks. High in vitamin C and antioxidants, they offer a delicious and nutritious treat."));
//
//        products.add(new Product(42L, "Jackfruit", 40.0F, 30.00F, 1L,
//                "Our jackfruits are sweet and fibrous, with a unique, tropical flavor. Perfect for snacking, cooking, or blending into smoothies. High in vitamins and fiber, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(43L, "Mangosteen", 30.0F, 35.00F, 1L,
//                "Our mangosteens are sweet and tangy, with a juicy, succulent texture. Perfect for snacking, adding to fruit salads, or blending into drinks. High in antioxidants and vitamins, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(44L, "Sapodilla", 22.0F, 50.00F, 1L,
//                "Our sapodillas are sweet and malty, with a smooth, grainy texture. Perfect for snacking, adding to desserts, or blending into smoothies. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(45L, "Custard Apple", 34.0F, 40.00F, 1L,
//                "Our custard apples are sweet and creamy, with a custard-like texture. Perfect for snacking, adding to desserts, or blending into smoothies. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(46L, "Persimmon", 25.0F, 55.00F, 1L,
//                "Our persimmons are sweet and juicy, with a smooth, tender texture. Perfect for snacking, baking, or adding to salads. High in vitamins A and C, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(47L, "Quince", 20.0F, 60.00F, 1L,
//                "Our quinces are aromatic and tart, with a unique, firm texture. Perfect for cooking, making jams, or baking into desserts. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(48L, "Jujube", 18.0F, 65.00F, 1L,
//                "Our jujubes are sweet and chewy, with a unique, date-like flavor. Perfect for snacking, adding to desserts, or making tea. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(49L, "Loquat", 22.0F, 55.00F, 1L,
//                "Our loquats are sweet and tangy, with a juicy, succulent texture. Perfect for snacking, adding to salads, or blending into smoothies. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(50L, "Kumquat", 18.0F, 60.00F, 1L,
//                "Our kumquats are small and tangy, with a sweet, edible skin. Perfect for snacking, adding to salads, or making marmalade. High in vitamin C and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        // Berries
//        products.add(new Product(51L, "Bilberry", 26.0F, 35.00F, 2L,
//                "Our bilberries are small and sweet, with a rich, blueberry-like flavor. Perfect for snacking, adding to cereals, or baking into desserts. High in antioxidants and vitamins, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(52L, "Huckleberry", 28.0F, 30.00F, 2L,
//                "Our huckleberries are sweet and tart, with a unique, rich flavor. Perfect for snacking, adding to cereals, or baking into desserts. High in antioxidants and vitamins, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(53L, "Boysenberry", 22.0F, 40.00F, 2L,
//                "Our boysenberries are juicy and sweet, with a rich, complex flavor. Perfect for snacking, adding to desserts, or making jams. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(54L, "Cloudberry", 32.0F, 25.00F, 2L,
//                "Our cloudberries are sweet and tangy, with a unique, rich flavor. Perfect for snacking, adding to desserts, or making jams. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(55L, "Currant", 20.0F, 45.00F, 2L,
//                "Our currants are tart and tangy, perfect for adding to salads, baking, or making jams. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste. Enjoy their vibrant color and unique flavor."));
//
//        products.add(new Product(56L, "Serviceberry", 24.0F, 30.00F, 2L,
//                "Our serviceberries are sweet and juicy, with a unique, rich flavor. Perfect for snacking, adding to cereals, or baking into desserts. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));
//
//        products.add(new Product(57L, "Barberry", 28.0F, 35.00F, 2L,
//                "Our barberries are tart and tangy, perfect for adding to dishes, baking, or making jams. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste. Enjoy their vibrant color and unique flavor."));
//
//        products.add(new Product(58L, "Lingonberry", 30.0F, 25.00F, 2L,
//                "Our lingonberries are tart and tangy, perfect for adding to salads, baking, or making jams. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste. Enjoy their vibrant color and unique flavor."));
//
//        products.add(new Product(59L, "Sea Buckthorn", 35.0F, 20.00F, 2L,
//                "Our sea buckthorns are tart and tangy, perfect for adding to dishes, making juices, or blending into smoothies. High in vitamins and antioxidants, they offer numerous health benefits and a unique, delicious taste."));
//
//        products.add(new Product(60L, "Salmonberry", 28.0F, 30.00F, 2L,
//                "Our salmonberries are sweet and juicy, with a unique, vibrant flavor. Perfect for snacking, adding to salads, or making jams. High in vitamins and antioxidants, they offer numerous health benefits and a delicious taste."));


        return products;
    }


}
