/**
 * Sets up an image upload functionality. When the upload button is clicked, the selected image file is read and sent to the server.
 *
 * @param {string} btnSelector - The CSS selector for the upload button.
 * @param {string} folder - The folder where the image will be uploaded.
 * @param {string} inputImageSelector - The CSS selector for the file input element.
 */
export function uploadImage(btnSelector, folder, inputImageSelector) {
	const uploadBtn = document.querySelector(btnSelector);
	const inputFiles = document.querySelector(inputImageSelector);

	uploadBtn.addEventListener('click', () => {
		const file = inputFiles.files[0];
		if (!file) {
			return inputFiles.click();
		}
		const reader = new FileReader();
		reader.readAsDataURL(file);
		reader.addEventListener('load', async () => {
			const data = reader.result.split(',')[1];
			const postData = {
				name: file.name,
				type: file.type,
				data: data
			};
			console.log(postData);
			await postFile(postData);
		});
	});
}

/**
 * Sends the file data to the server.
 *
 * @param {Object} postData - The data of the file to be uploaded.
 * @param {string} postData.name - The name of the file.
 * @param {string} postData.type - The type of the file.
 * @param {Array} postData.data - The file data in base64 format.
 * @returns {Promise<void>} - A promise that resolves when the file is uploaded.
 * @throws {Error} - Throws an error if the fetch request fails.
 */
async function postFile(postData) {
	try {
		const response = await fetch('https://script.google.com/macros/s/AKfycbxtR6kNUXpVsD3GZkNuXTMxEMPcIIG3hQx-jJraLkHrjpdnnr68Wf9ijFMyDB5nbO0-/exec', {
			method: 'POST',
			mode: 'cors',
			body: JSON.stringify(postData)
		});
		console.log('File uploaded successfully');
	} catch (error) {
		console.log('Error uploading file:', error);
	}
}
