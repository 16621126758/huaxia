//package cn.com.chnsys.data;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @Class: DateFormatThreadLocal
// * @description:
// * @Author: hongzhi.zhao
// * @Date: 2019-07-30 10:57
// */
//public class DateFormatThreadLocal {
//
//    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
//        @Override
//        protected DateFormat initialValue() {
//            return new SimpleDateFormat("yyyy-MM-dd");
//        }
//    };
//
//    public static Date convert(String resource) throws ParseException {
//        return df.get().parse(resource);
//    }
//}
