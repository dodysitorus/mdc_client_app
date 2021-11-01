@extends('template/home')
@section('judul','Tambah Data Dokter')
@section('content')
    <form action="{{route('dokter.store')}}" method="POST">
        @csrf
        <div class="form-group">
            @if(Session::has('success'))
                <div class="alert alert-success">
                    {{ Session::get('success') }}
                    @php
                        Session::forget('success')
                    @endphp
                </div>
            @endif
            <label>Nama Dokter</label>
            <input type="text" class="form-control" name="nama">
            @if($errors->has('nama'))
                <span class="text-danger">{{ $errors->first('nama') }}</span>
            @endif
        </div>
        <div class="form-group">
            <label>Spesialis</label>
            <input type="text" class="form-control" name="spesialis">
            @if($errors->has('spesialis'))
                <span class="text-danger">{{ $errors->first('spesialis') }}</span>
            @endif
        </div>
        <div class="form-group">
            <button class="btn btn-success">Tambah Dokter</button>
        </div>
    </form>
@endsection
