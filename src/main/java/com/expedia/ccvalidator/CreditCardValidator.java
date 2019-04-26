package com.expedia.ccvalidator;


public class CreditCardValidator {
    public static void main(String[] args) throws Exception {
        // start(spec -> spec
        //         .serverConfig(ServerConfig.embedded().port(8888)
        //                 .address(getByName("0.0.0.0"))
        //                 .baseDir(find()))
        //         .handlers(chain -> {
        //             BlacklistLoader blacklistLoader = new BlacklistLoader("/black-listed-credit-cards.json");

        //             BasicValidator basicValidator = new BasicValidator();
        //             BlackListedCardValidator blackListedCardValidator = new BlackListedCardValidator(blacklistLoader.load());
        //             ChecksumValidator checksumValidator = new ChecksumValidator();
        //             chain
        //                             .get("", ctx -> ctx.render("You're up and running"))
        //                             .get("validate", new CreditCardValidatorHandler(basicValidator, blackListedCardValidator, checksumValidator));
        //                 }
        //         )
        // );
    }
}
