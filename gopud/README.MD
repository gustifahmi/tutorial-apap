Tutorial 2

Pertanyaan 1:

Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%20Fasilkom&nomorTelepon=14022
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi!

Jawaban : Tidak bisa terbuka karena belum ada template yang menampilkan halaman html.

Pertanyaan 2:

Cobalah untuk menambahkan sebuah restoran dengan mengakses link
berikut:
http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin
%20FIK
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

Jawaban : Tidak berhasil, terjadi Error resolving template

Pertanyaan 3:

Jika Papa APAP ingin melihat restoran PanyuFC, link apa yang harus
diakses?

Jawaban : link yang perlu saya buka adalah http://localhost:8080/restoran/view?idRestoran=1

Pertanyaan 4:

Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk
mengakses http://localhost:8080/restoran/viewall, apa yang akan ditampilkan? Sertakan
juga bukti screenshotmu.

Jawaban : Tidak berhasil, terjadi Error resolving template

-----------------------------------------------------------

Tutorial 3

Pertanyaan 1:

Pada class MenuDb, terdapat method findByRestoranIdRestoran, apakah kegunaan dari method tersebut?

Jawaban : method tersebut mempunyai paramater yaitu idRestoran, dengan menggunakan idRestoran tersebut akan dicari
restoran yang dimaksud, lalu akan mengembalikan sebuah list yang berisi daftar seluruh menu makanan yang tersedia di
restoran tersebut.

Pertanyaan 2:

Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan
addRestoranSubmit?

Jawaban : method addRestoranFormPage menggunakan method GET yaitu akan menampilkan form untuk menambah restoran,
sedangkan method addRestoranSubmit menggunakan method POST yaitu mengirim/submit form yang telah diisi.

Pertanyaan 3:

Jelaskan apa kegunaan dari JPA Repository?

Jawaban : JPA Repository merupakan interface yang mengandung fitur-fitur dan atribut elemen yang memungkinkan
mendefinisikan repository beans.

Pertanyaan 4:

Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan
MenuModel dibuat?

Jawaban : Di class MenuModel terdapat sebuah line yaitu

private RestoranModel restoran;

Kode tersebut menunjukkan bahwa MenuModel mempunyai suatu attribute yang berbentuk RestoranModel, namun dalam
penerapannya adalah suatu menu secara unik dimiliki oleh sebuah restoran.

Begitu pula di class RestoranModel terdapat sebuah line yaitu

private List<MenuModel listMenu;

Kode tersebut menunjukkan bahwa suatu RestoranModel memiliki attribute yang berbentuk List yang berisi beberapa
MenuModel, berarti sebuah restoran memiliki beberapa menu.

Pertanyaan 5:

Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER?

Jawaban : Saya tidak tahu. 