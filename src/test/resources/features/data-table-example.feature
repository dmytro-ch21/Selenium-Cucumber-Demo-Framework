@regression
Feature: Demo the different ways of data tables in cucumber
  The Data tables will be used when we need to provide more than one data for a step
  In cases when we need to verify multiple points on a page at once with one launch to web page of the user
  The data can be passed as:
  - List<String>
  - Map<String, String>
  - List<List<String>>
  - List<Map<String, String>>
  - Custom Type


  # In cucumber to describe a test case we use Scenario keyword or we could use as well Example keyword
  # They are synonyms in cucumber - they are pretty much the same
  @listDataTable
  Example: Data table as a List
    Given this is a data table as a list
      | Omar  |
      | John  |
      | Merry |
      | Jane  |

  @mapDataTable
  Example: Data Table as a Map
    Given this is a data table as a map
      | first_name  | Omar |
      | middle_name | Mark |
      | last_name   | Ramo |


  @listOfListsDataTable
  Example: Data Table as a List of Lists
    Given this is a data table as a List of Lists
      | 12313 | Omar Mark          | Ramo      |
      | 13684 | Jonathan Pete Moss | Abernathy |
      | 13724 | test2 nn           | Anotation |

  @listOfMapsDataTable
  Example: Data Table as a List of Maps
    Given this is a data table as a List of Maps
      | id    | first_mid_name     | last_name |
      | 12313 | Omar Mark          | Ramo      |
      | 13684 | Jonathan Pete Moss | Abernathy |
      | 13724 | test2 nn           | Anotation |
