package step_definitions;

import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class DataTablesExampleSteps{

    @Given("this is a data table as a list")
    public void this_is_a_data_table_as_a_list(List<String> names) {
        System.out.println("--- This are the names from step def: ---");
        System.out.println(names);
    }

    @Given("this is a data table as a map")
    public void this_is_a_data_table_as_a_map(Map<String, String> person){
        System.out.println("--- This is the person from step def: ---");
        System.out.println(person);
        // We now can get any values from the maps
        System.out.println("First name: " + person.get("first_name"));
        System.out.println("Last name: " + person.get("last_name"));
    }

    @Given("this is a data table as a List of Lists")
    public void this_is_a_data_table_as_a_list_of_lists(List<List<String>> employees){
        System.out.println("--- This is the employees from step def: ---");
        for (List<String> employee: employees){
            System.out.println(employee);
        }
    }

    @Given("this is a data table as a List of Maps")
    public void this_is_a_data_table_as_a_list_of_maps(List<Map<String, String>> employees){
        System.out.println("--- This is the employees from step def as Maps: ---");
        System.out.println("Print ids:");
        for (Map<String, String> map: employees){
            System.out.println(map.get("id"));
        }

        System.out.println("Print Full Names:");
        for (Map<String, String> map: employees){
            System.out.println(map.get("first_mid_name") + " " + map.get("last_name"));
        }
    }

}
