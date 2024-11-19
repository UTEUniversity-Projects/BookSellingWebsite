export async function uploadSingleImage (btnSelector, folder, inputSelector, fileName = '') {
	try {
		const fileInput = document.querySelector(inputSelector);
		let file = fileInput?.files[0];
		if (!file) {
			return null;
		}

		const formData = new FormData();
		formData.append('image', file);
		formData.append('fileName', fileName);

		return await $.ajax({
			url: `${contextPath}/upload`,
			type: 'POST',
			data: formData,
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false
		});

	} catch (error) {
		console.error('Error uploading file:', error);
		return null;
	}
}

export async function uploadMultipleImage () {

}