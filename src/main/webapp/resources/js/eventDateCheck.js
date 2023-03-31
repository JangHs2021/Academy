
$(document).ready(function() {
    $("#startDate").change(function() {
        let startDate = new Date($(this).val());
        let endDate = new Date($("#endDate").val());
        if (startDate > endDate) {
            alert("시작 날짜는 종료 날짜보다 이전이어야 합니다.");
            $(this).val(""); // 시작 날짜 입력 값 초기화
        }
    });

    $("#endDate").change(function() {
        let startDate = new Date($("#startDate").val());
        let endDate = new Date($(this).val());
        if (startDate > endDate) {
            alert("종료 날짜는 시작 날짜보다 이후이어야 합니다.");
            $(this).val(""); // 종료 날짜 입력 값 초기화
        }
    });


    $('form').submit(function(event) {
        // 각 필드의 값이 비어있는지 검사
        if ($('#writer').val() == '' || $('#title').val() == '' || $('#startDate').val() == '' || $('#endDate').val() == '' || $('#contents').val() == '') {
            alert('모든 항목을 입력해주세요.');
            event.preventDefault(); // 서버로 데이터를 전송하지 않도록 막음
        }
    });


});
