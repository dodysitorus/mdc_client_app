@extends('template.home')
@section('judul','Pasien')
@section('content')
    @if(Session::has('success'))
        <div class="alert alert-success">
            {{ Session::get('success') }}
            @php
                Session::forget('success')
            @endphp
        </div>
    @endif
{{--    <a href="{{route('pasien.create')}}" class="btn btn-success">Tambah pasien</a>--}}

    <table class="table table-striped mb-0">
        <thead>
        <tr>
            <th>#</th>
            <th>ID Referal MDC</th>
            <th>Nama</th>
            <th>Tanggal Lahir</th>
            <th>Agama</th>
            <th>Telephone</th>
            <th>Biaya</th>
            <th>Dokter</th>
            <th>Klinik</th>
            <th>Action</th>
        </tr>
        </thead>
        @foreach($pasien as $result => $hasil)
            <tbody>
            <tr>
                <td>{{ $result + $pasien->firstitem() }}</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <form action="{{route('pasien.destroy',$hasil->id)}}" method="POST">
                        @csrf
                        @method('delete')
                        <a href="{{route('pasien.edit',$hasil->id)}}" class="btn btn-warning btn-action mr-1" data-toggle="tooltip" title="Edit"><i class="fas fa-pencil-alt"></i></a>
                        <button class="btn btn-danger" onclick="return confirm('Apakah Anda yakin menghapus data?')" data-toggle="tooltip" title="Delete" ><i class="fas fa-trash"></i></button>
                    </form>
                </td>
            </tr>
            </tbody>
        @endforeach
    </table>
    <br></br>
    {{$pasien->links('pagination::bootstrap-4')}}
@endsection

