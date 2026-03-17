package exercises.exer3;

public class EmailVerify {

    public static boolean verifyEmail(String email) {
        // é vazio ou tem espaço? se sim:
        if (email == null || email.isEmpty() || email.contains(" ")) {
            return false;
        }

        // tem 1 @? se não:
        int symbolIndex = email.indexOf('@');
        int lastSymbolIndex = email.lastIndexOf('@');
        if (symbolIndex == -1 || symbolIndex != lastSymbolIndex) {
            return false;
        }

        // @ inicio ou fim? se sim:
        if (symbolIndex == 0 || symbolIndex == email.length() - 1) {
            return false;
        }

        // tem '.' ? se não:
        String domainPart = email.substring(symbolIndex + 1);
        int firstDotIndexInDomain = domainPart.indexOf('.');
        if (firstDotIndexInDomain == -1) {
            return false;
        }

        // '.' depois do @ ou no final? se sim:
        int lastDotIndex = email.lastIndexOf('.');
        if (lastDotIndex == email.length() - 1 || lastDotIndex == symbolIndex + 1) {
            return false;
        }

        // tem pelo menos dois caracteres depois do '.'? se não:
        String end = email.substring(lastDotIndex + 1);
        if (end.length() < 2) {
            return false;
        }

        // tudo certo:
        return true;
    }

    public static void main(String[] args){
        System.out.println(verifyEmail("usuario@email.com"));
        System.out.println(verifyEmail("email-invalido"));
        System.out.println(verifyEmail("usuario@.com"));
        System.out.println(verifyEmail("usuario@email."));
    }
}
