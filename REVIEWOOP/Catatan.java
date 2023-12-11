/*
- Class dan Objek
Pak Finno menjelaskan class dan object dalam bentuk form sebuah acara
- Tipe Data
String : kalimat/kata dan diberi kutip 2 ""
Char : hanya 1 karakter aja, huruf awal kecil dan diberi kutip 1 ''
Variable : diawali huruf kecil, gak ada spasi dan spesial karakter
biasanya ada variabel dg uppercase, itu digunakan utk static/konstanta

- Percabangan
Guna percabangan untuk melakukan perandaian kondisi/pemilihan kondisi. Jika kondisinya A, maka
apa yang harus dilakukan, jika kondisinya B, maka apa yang harus dilakukan.
Terdapat 2 macam:
1. Switch Case -> digunakan jika mengetahui casenya dan kondisinya bersifat SAMA DENGAN.
Contoh: A == 1, A == 2
switch(A)
case A==?
Implementasi :
switch (a)
case 1:{
    // isinya apa yg harus dilakukan/action
}break;

2. IF -> digunakan untuk percabangan 
penggunaannya : if(kondisi)
Contoh:
if (a == 1){
    // isi action
} else if (a>=2)
    // isi action

- Perulangan
1. Do While
do {
    // tulis kode apa yg mau dilakukan
} while (kondisi)

contoh :
do {
    // tulis kode apa yg mau dilakukan
} while (a <= 10)
-> kode apa yg mau dilakukan akan dieksekusi dulu, lalu melihat
kondisi variavel a dan akan melakukan perulangan jika a <= 10. jd harus ada yg trigger
agar perulangan stop.

2. While
Cara penggunaan:
while(kondisi){

}
Contoh :
while(a <= 10){
    // tulis kode actionnya
}
-> sebelum menjalankan kode perulangan yg akan dilakukan, maka akan dicek terlebih dulu
kondisinya, jika kondisinya tidak TRUE (atau FALSE), maka program
tidak akan melakukan perulangan ini.

3. For
Cara penggunaan:
for(state awal; kondisi; progres)
Contoh:
for(int a= 0; a < 10; a++){
    //tulis code actionnya
}
Ini maksudnya, state awalnya a=0, dan bakal diulang hingga a < 10, kemudian
lakukan a=a+1 disetiap perulangan.

- Array
Ada 1 dimensi dan ada 2 dimensi:
1) 1 dimensi
index-0, index-1, index-2

2) 2 dimensi
index-0,0 ; index0,1 ; index-0,2
index-1,0 ; index-1,1; index-1,2

Cara inisiasi sebuah array, harus set berapa banyak yg bakal dibuat:
misal, butuh array String 1 dimensi sebanyak 10 row, jadi caranya:
String[] nama_variable = new String[10];

misal, 2 dimensi sebanyak 10x5, berarti caranya:
String[] nama_variable = new String[10][5];

Bagaimana cara tahu index terakhir dr sebuah array?
Utk 1 dimensi dg cara: nama-variable.length
Perulangan untuk array 1 dimensi:
    for (int a = 5, a>=0; a--){ //a = a-1
        // action
    }

*/

