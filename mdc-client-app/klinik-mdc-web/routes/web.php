<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\DokterControllerView;
use App\Http\Controllers\KlinikControllerView;
use App\Http\Controllers\LayananControllerView;
use App\Http\Controllers\PasienControllerView;
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

//dokter
Route::resource('dokter', DokterControllerView::class);

//klinik
Route::resource('klinik', KlinikControllerView::class);

//layanan
Route::resource('layanan',LayananControllerView::class);

//pasien
Route::resource('pasien',PasienControllerView::class);
