package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {
// ---------------------------------------------------------------------------------------------------------------- //
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }

// ---------------------------------------------------------------------------------------------------------------- //

    @ParameterizedTest
    @NullSource //Adiciona um parametro nulo no teste
    @EmptySource //Adiciona um parametro vazio no teste
    @NullAndEmptySource // Adiciona um parametro vazio e um parametro nulo no teste
    @ValueSource(strings = {"firstString", "secondString"})
    void stringsValues(String theParams){
        System.out.println("theParams = " + theParams);
    }

// ---------------------------------------------------------------------------------------------------------------- //

    @ParameterizedTest
    @CsvSource(value = {"steves,rogers", "captain,marvel", "bucky,barnes"})
    void csvSourse_StringString(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

// ---------------------------------------------------------------------------------------------------------------- //

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true", "captain,21,false", "bucky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

// ---------------------------------------------------------------------------------------------------------------- //

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv",
            "src/test/resources/params/shoppinglist.csv"}, numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name, double price,
                                                   int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

// ---------------------------------------------------------------------------------------------------------------- //

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist3.csv"}, numLinesToSkip = 1, delimiterString = "__")
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String name, double price,
                                                   int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

// ---------------------------------------------------------------------------------------------------------------- //

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceString")
    void methodSource_String(String param1){
        System.out.println("param1 = " + param1);
    }

// ---------------------------------------------------------------------------------------------------------------- //

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStringAsStream")
    void methodSource_StringStream(String param1){
        System.out.println("param1 = " + param1);
    }

// ---------------------------------------------------------------------------------------------------------------- //

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

// ---------------------------------------------------------------------------------------------------------------- //

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

}
