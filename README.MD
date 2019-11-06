# Tutorial APAP

## Authors

Gusti Fahmi Fadhila - 1706044036 - APAP-C

------------------------------------------------
Tutorial 7

1. Perbedaan Otentikasi dan Otorisasi
Otentikasi = Memvalidasi identitas user 
Otorisasi = Memberikan otoritas/kewenangan kepada user sesuai rolenya

2. BCryptPasswordEncoder
BCryptPasswordEncoder adalah sebuah class yang mengimplementasi class PasswordEncoder.
BCryptPasswordEncoder menggunakan fungsi hash BCrypt

3. Apa itu UUID dan mengap kita memakai UUID pada UserModel.java?
UUID adalah kepanjangan dari Universally Unique Identifier yang merepresentasikan sebuah long 128-bit yang bersifat unik.
standar representasi UUID adalah sebagai berikut:
123e4567-e89b-12d3-a456-556642440000
UUID terdiri dari hex digit masing-masing 4 char dengan 4 "-" simbol dengan total 36 characters.
Kita menggunakan UUID pada UserModel agar id User digenerate dengan UUID sehingga tidak bisa ditebak id tersebut dan user tidak bisa disalahgunakan.

4. Apa kegunaan UserDetailsServiceImpl.java? Mengapa harus ada kelas tersebut padahal kita sudah memiliki class UserServiceImpl.java?
UserDetailsServiceImpl merupakan sebuah class yang mengimplementasi class UserDetailsService yang telah disediakan spring.
UserDetailsServiceImpl digunakan untuk melakukan authorization kepada user yang melakukan login.
UserDetailsServiceImpl dibuat karena pada WebSecurityConfig dilakukan injection pada class UserDetailService sehingga butuh suatu kelas yang mengimplementasikan class UserDetailsService dan itu tidak bisa dilakukan di class UserServiceImpl yang sudah mengimplementasikan UserService