<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\DokterControllerJson;
use App\Http\Controllers\KlinikControllerJson;
use App\Http\Controllers\LayananControllerJson;
/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

//dokter
Route::resource('/dokter',DokterControllerJson::class);

//klinik
Route::resource('/klinik', KlinikControllerJson::class);

//layanan
Route::resource('/layanan',LayananControllerJson::class);
