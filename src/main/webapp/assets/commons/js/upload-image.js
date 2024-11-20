/**
 * Uploads an image to the server.
 *
 * @param {string} dir - The directory where the image should be uploaded.
 * @param {string} inputSelector - The selector for the file input element.
 * @param {string} [fileName=''] - An optional file name to be used on the server.
 * @returns {Promise<null|*>} - The server response if the upload is successful, or null if there was an error or no files were selected.
 */
export async function uploadImage(dir, inputSelector, fileName = '') {
	try {
		const fileInput = document.querySelector(inputSelector);
		let files = fileInput?.files;
		if (!files || files.length === 0) {
			return null;
		}

		const formData = new FormData();
		for (let i = 0; i < files.length; i++) {
			formData.append('files', files[i]);
		}
		formData.append('dir', dir);
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
