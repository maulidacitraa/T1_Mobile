fun main() {

    println("===== SISTEM PENILAIAN =====\n")

    // Input nama mahasiswa
    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine()!!

    // Input nilai UTS
    print("Masukkan Nilai UTS (0-100): ")
    val uts = readLine()!!.toDouble()

    // Input nilai UAS
    print("Masukkan Nilai UAS (0-100): ")
    val uas = readLine()!!.toDouble()

    // Input nilai tugas
    print("Masukkan Nilai Tugas (0-100): ")
    val tugas = readLine()!!.toDouble()

    // Menghitung nilai berdasarkan bobot masing-masing
    val bobotUTS = uts * 0.3
    val bobotUAS = uas * 0.4
    val bobotTugas = tugas * 0.3

    // Menghitung nilai akhir mahasiswa
    val nilaiAkhir = bobotUTS + bobotUAS + bobotTugas

    // Menentukan grade berdasarkan nilai akhir
    val grade = when {
        nilaiAkhir >= 85 -> "A"
        nilaiAkhir >= 70 -> "B"
        nilaiAkhir >= 60 -> "C"
        nilaiAkhir >= 50 -> "D"
        else -> "E"
    }

    // Memberikan keterangan berdasarkan grade
    val keterangan = when (grade) {
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        else -> "Sangat Kurang"
    }

    // Menentukan status kelulusan mahasiswa
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    // Menampilkan hasil penilaian
    println("\n===== HASIL PENILAIAN =====")
    println("Nama        : $nama")
    println("Nilai UTS   : $uts (Bobot 30%)")
    println("Nilai UAS   : $uas (Bobot 40%)")
    println("Nilai Tugas : $tugas (Bobot 30%)")
    println("-----------------------------")
    println("Nilai Akhir : $nilaiAkhir")
    println("Grade       : $grade")
    println("Keterangan  : $keterangan")
    println("Status      : $status")

    // Menampilkan pesan berdasarkan status kelulusan
    if (status == "LULUS") {
        println("\nSelamat! Anda dinyatakan LULUS.")
    } else {
        println("\nMaaf, Anda dinyatakan TIDAK LULUS.")
    }
}