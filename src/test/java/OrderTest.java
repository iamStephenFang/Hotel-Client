//import cn.edu.zjut.dao.OrderMapper;
//import cn.edu.zjut.po.Order;
//import com.opensymphony.xwork2.ActionContext;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//@Transactional
//@Rollback
//public class OrderTest {
//    private OrderMapper orderMapper = null;
//
//    @Autowired
//    public void setOrderMapper(OrderMapper orderMapper) {
//        this.orderMapper = orderMapper;
//    }
//    public OrderMapper getOrderMapper() {
//        return orderMapper;
//    }
//
//    @Test
//    public void restRoomNum() {
//        List<Order> orders = new ArrayList<Order>();
//
//        Calendar current = Calendar.getInstance();
//
//        current.set(2019,10,7);
//        Date checkInTime = current.getTime();
//
//        current.set(2019,10,15);
//        Date leaveTime = current.getTime();
//
//        try {
//            orders = orderMapper.findNonemptyRoom("双床房", checkInTime, leaveTime);
//            int roomTypeNum = 3;
//            int max=0;
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//            Date beginDate = dateFormat.parse(dateFormat.format(checkInTime));
//            Date endDate = dateFormat.parse(dateFormat.format(leaveTime));
//
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(beginDate);
//
//            int dateX=0;
//            while (!calendar.getTime().after(endDate)){
//                dateX++;
//                System.out.println("现在是第"+dateX+"天");
//                int count = 0;
//                for (Order order:orders){
//
//                    Date orderCheckInTime = dateFormat.parse(dateFormat.format(order.getCheckInTime()));
//                    System.out.println("订单号" + order.getOrderId() + "的checkImTime：" + dateFormat.format(orderCheckInTime));
//
//                    Date orderLeaveTime = dateFormat.parse(dateFormat.format(order.getLeaveTime()));
//                    System.out.println("订单号" + order.getOrderId() + "的leaveTime：" + dateFormat.format(orderLeaveTime));
//
//                    System.out.println("当前时间"+dateFormat.format(calendar.getTime()));
//                    System.out.println(!calendar.getTime().after(orderLeaveTime));
//                    System.out.println(!calendar.getTime().before(orderCheckInTime));
//
//                    if ((!calendar.getTime().after(orderLeaveTime)) && (!calendar.getTime().before(orderCheckInTime))){
//                        count++;
//                    }
//                }
//                System.out.println("第"+dateX+"天有"+count+"间霸占");
//                if (count > max) {
//                    max = count;
//                }
//                calendar.add(Calendar.DATE,1);
//            }
//            System.out.println(roomTypeNum - max);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
