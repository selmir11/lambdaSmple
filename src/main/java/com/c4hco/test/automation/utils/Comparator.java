package com.c4hco.test.automation.utils;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Comparator {

        public static Set<String> findCommonProperties(Class<?> class1, Class<?> class2) {
            Set<String> commonProperties = new HashSet<>();

            // Get fields of class1
            Field[] fields1 = class1.getDeclaredFields();
            // Get fields of class2
            Field[] fields2 = class2.getDeclaredFields();

            // Store field names of class1 in a set for fast lookup
            Set<String> fieldNamesSet = new HashSet<>();
            for (Field field1 : fields1) {
                fieldNamesSet.add(field1.getName());
            }

            // Iterate over fields of class2
            for (Field field2 : fields2) {
                // Check if the field name is present in the set of field names of class1
                if (fieldNamesSet.contains(field2.getName())) {
                    commonProperties.add(field2.getName());
                }
            }

            return commonProperties;
        }

        public static void compareCommonProperties(String className1, String className2) {
                try {
                    // Load the classes dynamically
                    Class<?> class1 = Class.forName(className1);
                    Class<?> class2 = Class.forName(className2);

                    // Example usage:
                    Set<String> commonProperties = findCommonProperties(class1, class2);
                    System.out.println("Common properties:");
                    for (String property : commonProperties) {
                        System.out.println(property);

                        // Compare field values
                        Field field1 = class1.getDeclaredField(property);
                        Field field2 = class2.getDeclaredField(property);

                        // Access field values from instances
                        field1.setAccessible(true);
                        field2.setAccessible(true);
                        Object value1 = field1.get(null); // null for static fields
                        Object value2 = field2.get(null); // null for static fields
                        System.out.println("================================================================================");
                        System.out.println("property, value1, value2:::::"+property+"::"+value1+"::"+value2);
                        // Example comparison: Compare field values
                        if (value1.equals(value2)) {
                            System.out.println("Values of " + property + " are equal: " + value1);
                        } else {
                            System.out.println("Values of " + property + " are not equal.");
                        }
                    }
                } catch (ClassNotFoundException | NoSuchFieldException e) {
                    System.out.println("Error: One or both classes not found.");
                    e.printStackTrace(); // Print stack trace for detailed error information
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

        }
    }
