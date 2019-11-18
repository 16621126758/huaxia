package cn.com.chnsys.Optional;

import cn.com.chnsys.pojo.Local.LocalAddress;
import cn.com.chnsys.pojo.Local.LocalCity;
import cn.com.chnsys.pojo.Local.LocalCountry;
import cn.com.chnsys.pojo.Local.LocalOrder;
import cn.com.chnsys.pojo.Local.LocalUser;
import cn.com.chnsys.pojo.taobao.TaobaoAdderss;
import cn.com.chnsys.pojo.taobao.TaobaoCity;
import cn.com.chnsys.pojo.taobao.TaobaoCountry;
import cn.com.chnsys.pojo.taobao.TaobaoOrder;
import cn.com.chnsys.pojo.taobao.TaobaoUser;
import java.util.Optional;
import org.junit.Test;

/**
 * @Class: TestOptional2
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:47
 */
public class TestOptional2 {

    @Test
    public void test(){
        TaobaoOrder taobaoOrder = generatorDate();
        System.out.println(taobaoOrder);
        LocalOrder localOrder = convertData2(taobaoOrder);
        System.out.println(localOrder);
    }


    public LocalOrder convertData(TaobaoOrder taobaoOrder){
        LocalCity localCity = null;
        LocalCountry localCountry = null;
        LocalAddress localAddress = null;
        TaobaoUser taobaoUser = null;
        LocalUser localUser = null;
        LocalOrder localOrder = null;
        if (null!=taobaoOrder){
              taobaoUser = taobaoOrder.getUser();
             localOrder = new LocalOrder();
             localOrder.setLocalUser(taobaoUser);
            if(null!=taobaoUser){
                TaobaoAdderss taobaoAdderss = taobaoUser.getTaobaoAdderss();
                localUser = new LocalUser();
                localUser.setLocalAddress(taobaoAdderss);
                if (null!=taobaoAdderss){
                    TaobaoCountry taobaoCountry = taobaoAdderss.getTaobaoCountry();
                    localAddress = new LocalAddress();
                    localAddress.getLocalCountry(taobaoAdderss);
                    if (null!=taobaoCountry){
                        TaobaoCity taobaoCity = taobaoCountry.getTaobaoCity();
                        localCountry = new LocalCountry();
                        localCountry.setLocalCity(taobaoCity);
                        if ("".equals(taobaoCity.getCityName())&&null!=taobaoCity.getCityName()){
                            localCity = new LocalCity();
                            localCity.setCityName(taobaoCity.getCityName());
                        }
                    }
                }
            }
        }
        return localOrder;

    }


    public LocalOrder convertData2(TaobaoOrder taobaoOrder){
        LocalCity localCity = new LocalCity();
        LocalOrder localOrder = new LocalOrder();
        LocalCountry localCountry = new LocalCountry();
        LocalAddress localAddress = new LocalAddress();
        LocalUser localUser = new LocalUser();
        Optional<TaobaoOrder> taobaoOrder1 = Optional.ofNullable(taobaoOrder);

        Optional<String> CityName = taobaoOrder1
                .map(TaobaoOrder::getUser)
                .map(TaobaoUser::getTaobaoAdderss)
                .map(TaobaoAdderss::getTaobaoCountry)
                .map(TaobaoCountry::getTaobaoCity)
                .map(TaobaoCity::getCityName);
        CityName.ifPresent(e->{
            localCity.setCityName(e);
        });

        Optional<TaobaoCity> taobaoCity = taobaoOrder1
                .map(TaobaoOrder::getUser)
                .map(TaobaoUser::getTaobaoAdderss)
                .map(TaobaoAdderss::getTaobaoCountry)
                .map(TaobaoCountry::getTaobaoCity);
        taobaoCity.ifPresent((e)->{
            localCountry.setLocalCity(taobaoCity.get());
        });

        Optional<TaobaoCountry> taobaoCountry = taobaoOrder1
                .map(TaobaoOrder::getUser)
                .map(TaobaoUser::getTaobaoAdderss)
                .map(TaobaoAdderss::getTaobaoCountry);
        taobaoCountry.ifPresent(e->{
            localAddress.setLocalCountry(taobaoCountry.get());
        });

        Optional<TaobaoAdderss> taobaoAdderss = taobaoOrder1
                .map(TaobaoOrder::getUser)
                .map(TaobaoUser::getTaobaoAdderss);
        taobaoAdderss.ifPresent(e->{
             localUser.setLocalAddress(taobaoAdderss.get());
        });

        Optional<TaobaoUser> taobaoUser = taobaoOrder1
                .map(TaobaoOrder::getUser);
        taobaoAdderss.ifPresent(e->{
            localOrder.setLocalUser(taobaoUser.get());
        });

        return localOrder;
    }

    public TaobaoOrder generatorDate(){
        TaobaoCity taobaoCity = new TaobaoCity();
        taobaoCity.setCityName("北京");
        TaobaoCountry taobaoCountry = new TaobaoCountry();
        taobaoCountry.setTaobaoCity(taobaoCity);
        TaobaoAdderss taobaoAdderss = new TaobaoAdderss();
        taobaoAdderss.setTaobaoCountry(taobaoCountry);
        TaobaoUser taobaoUser = new TaobaoUser();
        taobaoUser.setTaobaoAdderss(taobaoAdderss);
        TaobaoOrder taobaoOrder = new TaobaoOrder();
        taobaoOrder.setUser(taobaoUser);
        return taobaoOrder;
    }

}
