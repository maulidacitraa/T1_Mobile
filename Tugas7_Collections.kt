// Data class untuk menyimpan informasi mahasiswa
data class DataNilai(
    val nim: String,
    val nama: String,
    val matkul: String,
    val nilai: Int
)

// Fungsi untuk mengubah nilai angka menjadi grade huruf
fun konversiGrade(nilai: Int): String {
    return when {
        nilai >= 85 -> "A"
        nilai >= 70 -> "B"
        nilai >= 60 -> "C"
        nilai >= 50 -> "D"
        else -> "E"
    }
}

// Fungsi untuk memberikan keterangan dari grade
fun deskripsiGrade(grade: String): String {
    return when (grade) {
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        else -> "Sangat Kurang"
    }
}

fun main() {
    // Membuat list yang berisi data 10 mahasiswa
    val daftar = listOf(
        DataNilai("2024001","Budi Santoso","Pemrograman",85),
        DataNilai("2024002","Ani Wijaya","Pemrograman",92),
        DataNilai("2024003","Citra Dewi","Pemrograman",68),
        DataNilai("2024004","Rizky Pratama","Pemrograman",45),
        DataNilai("2024005","Salsa Maharani","Pemrograman",78),
        DataNilai("2024006","Dimas Saputra","Pemrograman",55),
        DataNilai("2024007","Nabila Putri","Pemrograman",90),
        DataNilai("2024008","Bagas Nugraha","Pemrograman",72),
        DataNilai("2024009","Tasya Ramadhani","Pemrograman",63),
        DataNilai("2024010","Aditya Firmansyah","Pemrograman",38)
    )

    println("===== DATA NILAI MAHASISWA =====\n")

    println("No  NIM        Nama               MataKuliah     Nilai  Grade")

    // Menampilkan seluruh data mahasiswa menggunakan forEachIndexed
    daftar.forEachIndexed { i, m ->
        // Mengubah nilai angka menjadi grade
        val grade = konversiGrade(m.nilai)
        // Menampilkan data dengan format tabel
        println(
            "${(i+1).toString().padEnd(3)}" +
                    "${m.nim.padEnd(11)}" +
                    "${m.nama.padEnd(19)}" +
                    "${m.matkul.padEnd(15)}" +
                    "${m.nilai.toString().padEnd(7)}" +
                    grade
        )
    }

    // Bagian statistik nilai mahasiswa
    println("\n===== STATISTIK =====")

    // Menghitung jumlah total mahasiswa
    val total = daftar.size
    println("Total Mahasiswa : $total")

    // Menghitung rata-rata nilai menggunakan map dan average
    val rata = daftar.map { it.nilai }.average()
    println("Rata-rata Nilai : ${"%.1f".format(rata)}")

    // Mencari mahasiswa dengan nilai tertinggi
    val nilaiMax = daftar.maxByOrNull { it.nilai }!!

    // Mencari mahasiswa dengan nilai terendah
    val nilaiMin = daftar.minByOrNull { it.nilai }!!

    println("Nilai Tertinggi : ${nilaiMax.nilai} (${nilaiMax.nama})")
    println("Nilai Terendah  : ${nilaiMin.nilai} (${nilaiMin.nama})")

    // Menampilkan mahasiswa yang lulus (nilai >= 70)
    println("\n===== MAHASISWA LULUS =====")

    // Menggunakan filter untuk mengambil mahasiswa yang nilainya >= 70
    val lulus = daftar.filter { it.nilai >= 70 }

    lulus.forEachIndexed { i, m ->
        println("${i+1}. ${m.nama} - ${m.nilai} (${konversiGrade(m.nilai)})")
    }

    // Menampilkan mahasiswa yang tidak lulus (nilai < 70)
    println("\n===== MAHASISWA TIDAK LULUS =====")

    val tidakLulus = daftar.filter { it.nilai < 70 }

    tidakLulus.forEachIndexed { i, m ->
        println("${i+1}. ${m.nama} - ${m.nilai} (${konversiGrade(m.nilai)})")
    }

    // Mengelompokkan mahasiswa berdasarkan grade
    println("\n===== MAHASISWA PER GRADE =====")

    // groupBy digunakan untuk mengelompokkan data
    val grup = daftar.groupBy { konversiGrade(it.nilai) }

    // Menampilkan setiap kelompok grade
    grup.toSortedMap().forEach { (grade, listMhs) ->
        println("\nGrade $grade - ${deskripsiGrade(grade)} (${listMhs.size} mahasiswa)")
        listMhs.forEach {
            println(" • ${it.nama} (${it.nilai})")
        }
    }

    // Menghitung jumlah mahasiswa untuk setiap grade
    println("\n===== JUMLAH PER GRADE =====")

    val daftarGrade = listOf("A","B","C","D","E")

    daftarGrade.forEach { g ->
        val jumlah = daftar.count { konversiGrade(it.nilai) == g }
        println("Grade $g : $jumlah mahasiswa")
    }

    // Menandakan program selesai dijalankan
    println("\n===== SELESAI =====")
}