package com.Mobitel.MobitelFront.Controller;



import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Mobitel.MobitelBack.dao.CartDAO;
import com.Mobitel.MobitelBack.dao.OrderDAO;
import com.Mobitel.MobitelBack.model.Cart;
import com.Mobitel.MobitelBack.model.Order;


@Controller
public class OrderController {
	@Autowired
	CartDAO cartDAO;

	@Autowired
	OrderDAO orderDAO;

	@RequestMapping("/CheckOut")
	public String orderConfirm(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		List<Cart> list=cartDAO.getCartItems(username);
		 
		int grandtotal=0;
		for(Cart cart:list)
		{
			grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
			
		}
		m.addAttribute("grandtotal", grandtotal);
		m.addAttribute("cartlist", list);
		return "CheckOut";
	}
	/*@RequestMapping("/pay")
	public String Confirmation(Model m,HttpSession session)
	{
		String username=(String) session.getAttribute("username");
		List<Orders> orderlist=ordersDAO.getOrdersDetails(username);
		
		m.addAttribute("orderlist",orderlist);
		
		
		return "ThankPage";
	}
	
	*/
	@RequestMapping("/payment")
	public String payment(@RequestParam("paymode") String paymode,@RequestParam("shipping") String shipping,Model m,HttpSession session)
	{
		
		String username=(String) session.getAttribute("username");
		Order order=new Order();
		order.setPaymode(paymode);
		order.setShipmentaddress(shipping);
		order.setUsername(username);
		order.setStatus("Y");
		orderDAO.insertUpdateOrder(order);	
		
		
		List<Cart> cartlist=cartDAO.getCartDetails(username);
		for(Cart cart:cartlist)
		{
			 cart=cartDAO.getCartItem(cart.getCartItemid());
			cart.setStatus("y");
			cartDAO.addToCart(cart);
			
		}
		
		
		return "redirect:/pay";
		
	}
	
	
}
