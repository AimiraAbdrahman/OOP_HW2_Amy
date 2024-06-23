public enum EProduct {
    
    FRUIT ("ФРУКТ"),
    VEGETABLE ("ОВОЩ"),
    DRINK ("НАПИТОК"),
    BREAD ("ХЛЕБ");

    private String title;

    EProduct(String string) {
        this.title = string;
    }

    public String getTitle() {
       return title;
   }
}
