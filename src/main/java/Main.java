import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }

    public void run() throws IOException {
        calculate();
        System.out.println(calculate());
        countNum();
        Writer.write("result", calculate());
    }

    public double calculate() throws IOException {
        checkSkobka();
        Map<String, Double> vars = new HashMap<String, Double>();
        vars.put("x", 1.2);
        vars.put("y", 2.2);
        ExpressionBuilder expressionBuilderb = new ExpressionBuilder(Reader.function("func"));
        expressionBuilderb.variables("x","y","z");
        Expression ex =expressionBuilderb.build();
        ex.setVariables(vars);
        double result = ex.evaluate();
        return result;
    }

//    private String function() {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter function:");
//        String function = in.nextLine();
//        return function;
//    }

    public boolean checkSkobka(){
        Deque deque = new LinkedList<>();
        try {
            for (char ch: Reader.function("func").toCharArray()) {
                if (ch == '(') {
                    deque.addFirst(ch);
                } else {
                    if (!deque.isEmpty() && deque.peekFirst().equals('(')  && ch == ')')
                            {
                        deque.removeFirst();
                    } else {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void countNum() throws IOException {
        int count = 0;
        boolean contDigits = false;
        for (int i = 0; i < Reader.function("func").length(); i++) {
             if(Character.isDigit(toString().charAt(i))){
                 contDigits = true;
             }
            if (Character.isDigit(toString().charAt(i))&& contDigits) {
                count++;
                contDigits =false;
            }
        }
        if(contDigits){
            count++;
        }
        System.out.println("Количество чисел:"+ count);
    }

    }




