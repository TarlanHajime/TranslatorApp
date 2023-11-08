package util;

import enums.Option;

public class MenuUtil {

    public static int firstMenu() {
        System.out.println(">>>>>>>>>>>>>>> Translator_App <<<<<<<<<<<<<<<\n" +
                Option.EXIT.getVal() +
                Option.START.getVal() +
                Option.ADD_WORD.getVal() +
                Option.SEE_HISTORY.getVal() +
                ">>>>>>>>>>>>>>> Translator_App <<<<<<<<<<<<<<<"
        );
        return InputUtil.inputRequiredInt("Please choose option: ");
    }
}
