<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreatePasiensTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('pasien', function (Blueprint $table) {
            $table->id();
            $table->string('referal_id_mdc');
            $table->string('nama');
            $table->string('tanggal_lahir');
            $table->string('agama');
            $table->string('telephone');
            $table->double('biaya');
            $table->string('dokter');
            $table->string('klinik');
            $table->unsignedBigInteger('id_dokter');
            $table->foreign('id_dokter')->references('id')->on('dokter');
            $table->unsignedBigInteger('id_klinik');
            $table->foreign('id_klinik')->references('id')->on('klinik');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('pasiens');
    }
}
