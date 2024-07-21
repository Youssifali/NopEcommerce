package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlist extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObj;
    ProductDetailsPage detailsObj;
    WishlistPage wishlistObj;
    @Test(priority = 1)
    public void UserCanSearchWithAutoSuggest(){
        searchObj=new SearchPage(driver);
        searchObj.productSearchUsingAutoSuggest("macb");
        detailsObj = new ProductDetailsPage(driver);
        Assert.assertEquals(detailsObj.getProductNameBreadCrumb().getText(),productName);
    }
    @Test(priority = 2)
    public void UserCanAddProductToWishlist(){
        detailsObj = new ProductDetailsPage(driver);
        detailsObj.addProductToWishlist();
        wishlistObj = new WishlistPage(driver);
        Assert.assertTrue(wishlistObj.getWishlistHeader().isDisplayed());
        Assert.assertTrue(wishlistObj.getProductCell().getText().contains(productName));
    }
    @Test(priority = 3)
    public void UserCanRemoveProductFromWishlist(){
        wishlistObj = new WishlistPage(driver);
        wishlistObj.removeProductFromWishlist();
        Assert.assertTrue(wishlistObj.getEmptyCartLbl().getText().contains("The wishlist is empty!"));
    }
}
