package cn.com.chnsys.Batch;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class: BashSend
 * @description: 一个系统，如果有10万个用户，给每个用法发送一条祝福短信怎么做可以提高效率。
 * 使用多线程分批进行处理
 * @Author: hongzhi.zhao
 * @Date: 2019-08-20 10:45
 */
public class BashSend implements Runnable {

    private List<UserEntity> listUser;
    public BashSend(List<UserEntity> listUser ) {
        this.listUser=listUser;
    }


    @Override
    public void run() {
        for (UserEntity userEntity : listUser) {
            System.out.println(Thread.currentThread().getName()+","+userEntity.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //初始化数据
        List<UserEntity> list = initUser();
//        定义每个线程分批发送的大小
        int sendCount = 2;
// 3.计算每个线需要分配跑的数据
        List<List<UserEntity>> splitList = ListUtils.splitList(list, sendCount);
        for (int i = 0; i < splitList.size(); i++) {
            List<UserEntity> list1 = splitList.get(i);
            BashSend userSendThread = new BashSend(list1);
            // 4.分配发送
            Thread thread = new Thread(userSendThread,"线程"+i);
            thread.start();
        }

    }


    public static List<UserEntity> initUser(){
        List<UserEntity> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add(new UserEntity("userId"+i,"userName"+i));
        }
        return list;
    }




}
