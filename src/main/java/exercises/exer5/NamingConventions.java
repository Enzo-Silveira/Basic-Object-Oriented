package exercises.exer5;

public class NamingConventions {
    public enum Convention {VARIABLE, CONSTANT, CLASS, METHOD}

    public static boolean isFollowingConvetion(String name, Convention convention){
        if(name == null || name.isEmpty()){
            return false;
        }
        switch (convention){
            case VARIABLE:
                return name.matches("^[a-z][a-zA-Z0-9]*$"); //camelCase
            case CONSTANT:
                return name.matches("^[A-Z][A-Z0-9_]*$"); //UPPER_CASE
            case CLASS:
                return name.matches("^[A-Z][a-zA-Z0-9]*$"); //PascalCase
            case METHOD:
                return name.matches("^[a-z][a-zA-Z0-9]*$"); //camelCase
            default:
                return false;
        }
    }

    public static String fromConstToVariable(String cont){
        if(cont == null || cont.isEmpty()){
            return cont;
        }
        String[] parts = cont.toLowerCase().split("_");

        StringBuilder result = new StringBuilder();

        result.append(parts[0]);

        for(int i = 1; i < parts.length; i++){
            String caracter = parts[i].toUpperCase().charAt(0) + parts[i].substring(1);
            result.append(caracter);
        }

        return result.toString();
    }

    public static String fromVariableToConst(String variable){
        if(variable == null || variable.isEmpty()){
            return variable;
        }
        StringBuilder result = new StringBuilder();
        for(char c : variable.toCharArray()){
            if(Character.isUpperCase(c)){
                result.append("_");
            }
            result.append(Character.toUpperCase(c));
        }
        return result.toString();
    }

    public static boolean isValidJavaIdentifier(String identifier){
        if(identifier == null || identifier.isEmpty()){
            return false;
        }
        if(!Character.isJavaIdentifierStart(identifier.charAt(0))){
            return false;
        }
        for(int i = 1;i<identifier.length();i++){
           if(!Character.isJavaIdentifierPart(identifier.charAt(i))){
                return false;
           }
        }
        return true;
    }

}
