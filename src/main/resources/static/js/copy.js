function copyUrl() {
	const text = document.getElementById("loginUrl").innerText;
	
	navigator.clipboard.writeText(text).then(() => {
		const msg = document.getElementById("copyMessage");
		msg.style.display = "inline";
		
		setTimeout(() => {
			msg.style.display = "none";
		},2000);
	});
}