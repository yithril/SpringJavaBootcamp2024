let categoryService;

class CategoryService {


    getAllCategories(callback)
    {
        const url = `${config.baseUrl}/categories`;

        return axios.get(url)
            .then(response => {
                callback(response.data);
            })
            .catch(error => {

                const data = {
                    error: "Loading categories failed."
                };

                templateBuilder.append("error", data, "errors")
            });
    }
}

document.addEventListener('DOMContentLoaded', () => {
    categoryService = new CategoryService();
});
