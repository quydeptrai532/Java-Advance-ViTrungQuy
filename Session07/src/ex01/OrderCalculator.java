package ex01;

public class OrderCalculator {
    double caculator(Order oder){
         double total=0;
         for(Product p:oder.products){
             total+=p.price;
         }
         return  total;
    }
}
