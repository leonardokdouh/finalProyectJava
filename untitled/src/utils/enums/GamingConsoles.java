package utils.enums;public enum GamingConsoles {
        NINTENDO_DS ("Nintendo DS"),
        XBOX ("Xbox"),

        PS5("Ps5");

        private final String value;

    GamingConsoles(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

}
