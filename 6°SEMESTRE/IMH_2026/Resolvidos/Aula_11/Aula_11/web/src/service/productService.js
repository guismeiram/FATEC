// src/services/productService.js
import axios from 'axios';

//const baseURL = 'https://localhost:31912/api/products';
const baseURL = process.env.REACT_APP_API_URL;
const productService = {
    getAllProducts: async () => {
        try {
            const response = await axios.get(
                baseURL,
                {
                    timeout: 3000,
                    headers: {
                        Accept: 'application/json',
                    },
                },
            );
            return response.data;
        } catch (err) {
            if (err.code === 'ECONNABORTED') {
                console.log('The request timed out.');
            } else {
                console.log(err);
            }
        }
    },
    addProduct: async (product) => {
        const response = await axios.post(baseURL, product);
        return response.data;
    },
    deleteProduct: async (id) => {
        const response = await axios.delete(`${baseURL}/${id}`);
        return response.data;
    },
    updateProduct: async (id, product) => {
        const response = await axios.put(`${baseURL}/${id}`, product);
        return response.data;
    }
};
export default productService;