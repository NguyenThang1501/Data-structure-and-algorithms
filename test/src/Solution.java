public class Solution {
    class CD {

        private int maCD;
        private String tenCD;
        private String caSi;
        private int maBH;
        private int Gia;

        public int getMaCD() {
            return maCD;
        }

        public void setMaCD(int maCD) {
            this.maCD = maCD;
        }

        public String getTenCD() {
            return tenCD;
        }

        public void setTenCD(String tenCD) {
            this.tenCD = tenCD;
        }

        public String getCaSi() {
            return caSi;
        }

        public void setCaSi(String caSi) {
            this.caSi = caSi;
        }

        public int getMaBH() {
            return maBH;
        }

        public void setMaBH(int maBH) {
            this.maBH = maBH;
        }

        public int getGia() {
            return Gia;
        }

        public void setGia(int gia) {
            Gia = gia;
        }

        public CD() {
        }

        public CD(int maCD, String tenCD, String caSi, int maBH, int gia) {
            this.maCD = maCD;
            this.tenCD = tenCD;
            this.caSi = caSi;
            this.maBH = maBH;
            Gia = gia;
        }

        @Override
        public String toString() {
            return "CD{" +
                    "maCD=" + maCD +
                    ", tenCD='" + tenCD + '\'' +
                    ", caSi='" + caSi + '\'' +
                    ", maBH=" + maBH +
                    ", Gia=" + Gia +
                    '}';
        }


    }
    class cdManager{
        CD[] cds;
        int soLuong = 0;

        public boolean add(CD cd){
            if (soLuong <= cds.length){
                for (int i=0; i< soLuong; i++){
                    if (cds[i].maCD == cd.maCD){
                        return false;
                    }
                }
                cds[soLuong] = cd;
                soLuong++;
                return true;
            }
            return false;
        }

    }


}