package cn.com.chnsys.pojo.taobao;

/**
 * @Class: TaobaoUser
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:40
 */
public class TaobaoUser {
    private TaobaoAdderss taobaoAdderss;

    public TaobaoAdderss getTaobaoAdderss() {
        return taobaoAdderss;
    }

    public void setTaobaoAdderss(TaobaoAdderss taobaoAdderss) {
        this.taobaoAdderss = taobaoAdderss;
    }

    @Override
    public String toString() {
        return "TaobaoUser{" +
                "taobaoAdderss=" + taobaoAdderss +
                '}';
    }
}
