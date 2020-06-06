$(document).ready(function() {
    $('#example').DataTable();
    $('#example-1').DataTable();
    $('#example-2').DataTable();
} );
$(document).ready(function() {
    $('#ex').DataTable( {
        autoWidth: false,
        columnDefs: [
            {
                targets: ['_all'],
                className: 'mdc-data-table__cell'
            }
        ]
    } );
} );