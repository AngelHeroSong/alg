package annotation;

public class Apple {

    @FruitProvider(id = 1,name = "红富士",address = "栖霞")
    private AppleProvider appleProvider;

    public AppleProvider getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(AppleProvider appleProvider) {
        this.appleProvider = appleProvider;
    }
}
