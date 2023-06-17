//Дана строка sql-запроса "select * from students where ".
//Сформируйте часть WHERE этого запроса, используя StringBuilder.
//Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

public class lab2_1 {
    public static void main(String[] args) {

        StringBuilder builder1 = new StringBuilder("select * from students where ");
        StringBuilder builder2 = new StringBuilder("{\"name\":\"Ivanov\"," +
                " \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");

        builder2.delete(0,2);
        builder2.delete(builder2.length()-2,builder2.length());
        changeSymbol(builder2, "\"", "");
        changeSymbol(builder2, ":", "=");

        while (builder2.indexOf("null")!=-1){
            if(builder2.lastIndexOf(",", builder2.indexOf("null")) == -1){
                builder2.delete(0, builder2.indexOf("null")+5);
            }
            else {
                builder2.delete(builder2.lastIndexOf(",", builder2.indexOf("null")), builder2.indexOf("null")+4);
            }

        }

        System.out.println(builder1.append(builder2));
    }

    public static StringBuilder changeSymbol(StringBuilder builder, String x, String y){
        while (builder.indexOf(x) != -1){
            builder.replace(builder.indexOf(x), builder.indexOf(x)+1, y);
        }
        return builder;
    }
}