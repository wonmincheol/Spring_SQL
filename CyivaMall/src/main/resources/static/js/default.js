// 상품 목록으로 이동
const goList = () => {
	location.href = "/list";
}
// 수정 페이지로 이동
const goUpdate = () => {
	location.href = "/goUpdate/"+id;
}
// 삭제 페이지로 이동
const goDelete = () => {
	//alert("삭제 버튼");
	const ok = confirm("삭제하시겠습니까?");
	if(ok){
		location.href = "/goDelete/"+id;
	}
}
