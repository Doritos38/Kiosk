package com.example.kiosk.lv6;

public enum User {      //      유형별 할인정보
    MERITORIOUS {
        @Override
        public Double discount(double total) {
            return total - total * 0.1;
        }
    },
    SOLDIER {
        @Override
        public Double discount(double total) {
            return total - total * 0.05;
        }
    },
    STUDENT {
        @Override
        public Double discount(double total) {
            return total - total * 0.03;
        }
    },
    PERSON {
        @Override
        public Double discount(double total) {
            return total;
        }
    };

    public abstract Double discount(double total);
}
