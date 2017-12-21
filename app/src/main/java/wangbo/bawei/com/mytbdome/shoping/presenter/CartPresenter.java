package wangbo.bawei.com.mytbdome.shoping.presenter;


import wangbo.bawei.com.mytbdome.fragment.ShopPing;
import wangbo.bawei.com.mytbdome.shoping.model.CartModel;
import wangbo.bawei.com.mytbdome.shoping.presenter.interfac.ICartPresenter;
import wangbo.bawei.com.mytbdome.shoping.view.IView.IMainActivity;

/**
 * Created by Dash on 2017/12/12.
 */
public class CartPresenter implements ICartPresenter {

    private final CartModel cartModel;
    private IMainActivity iMainActivity;

    public CartPresenter(ShopPing iMainActivity) {
        this.iMainActivity = iMainActivity;
        cartModel = new CartModel(this);
    }

    public void getCartData(String cartUrl) {
        cartModel.getCartData(cartUrl);

    }

    @Override
    public void getSuccessCartJson(String json) {
        //回调给view
        iMainActivity.getSuccessCartData(json);
    }
}
