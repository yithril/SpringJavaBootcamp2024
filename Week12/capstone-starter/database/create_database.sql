USE sys;

# ---------------------------------------------------------------------- #
# Target DBMS:           MySQL                                           #
# Project name:          EasyShop                                        #
# ---------------------------------------------------------------------- #
DROP DATABASE IF EXISTS easyshop;

CREATE DATABASE IF NOT EXISTS easyshop;

USE easyshop;

# ---------------------------------------------------------------------- #
# Tables                                                                 #
# ---------------------------------------------------------------------- #

CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    hashed_password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE profiles (
    user_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(200) NOT NULL,
    address VARCHAR(200) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip VARCHAR(20) NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE categories (
    category_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    PRIMARY KEY (category_id)
);

CREATE TABLE products (
    product_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    category_id INT NOT NULL,
    description TEXT,
    color VARCHAR(20),
    image_url VARCHAR(200),
    stock INT NOT NULL DEFAULT 0,
    featured BOOL NOT NULL DEFAULT 0,
    PRIMARY KEY (product_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE orders (
    order_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    date DATETIME NOT NULL,
    address VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip VARCHAR(20) NOT NULL,
    shipping_amount DECIMAL(10, 2) NOT NULL DEFAULT 0,
    PRIMARY KEY (order_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE order_line_items (
    order_line_item_id INT NOT NULL AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    sales_price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    discount DECIMAL(10, 2) NOT NULL DEFAULT 0,
    PRIMARY KEY (order_line_item_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- new tables
CREATE TABLE shopping_cart (
	user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    PRIMARY KEY (user_id, product_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);


/*  INSERT Users  */
INSERT INTO users (username, hashed_password, role) 
VALUES  ('user','$2a$10$NkufUPF3V8dEPSZeo1fzHe9ScBu.LOay9S3N32M84yuUM2OJYEJ/.','ROLE_USER'),
        ('admin','$2a$10$lfQi9jSfhZZhfS6/Kyzv3u3418IgnWXWDQDk7IbcwlCFPgxg9Iud2','ROLE_ADMIN'),
        ('george','$2a$10$lfQi9jSfhZZhfS6/Kyzv3u3418IgnWXWDQDk7IbcwlCFPgxg9Iud2','ROLE_USER');

/* INSERT Profiles */
INSERT INTO profiles (user_id, first_name, last_name, phone, email, address, city, state, zip)
VALUES  (1, 'Joe', 'Joesephus', '800-555-1234', 'joejoesephus@email.com', '789 Oak Avenue', 'Dallas', 'TX', '75051'),
        (2, 'Adam', 'Admamson', '800-555-1212', 'aaadamson@email.com', '456 Elm Street','Dallas','TX','75052'),
        (3, 'George', 'Jetson', '800-555-9876', 'george.jetson@email.com', '123 Birch Parkway','Dallas','TX','75051')     ;

/* INSERT Categories */
INSERT INTO categories (name, description) 
VALUES  ('Electronics', 'Explore the latest gadgets and electronic devices.'),
        ('Fashion', 'Discover trendy clothing and accessories for men and women.'),
        ('Home & Kitchen', 'Find everything you need to decorate and equip your home.');

/* INSERT Products */
-- electronics
INSERT INTO products (name, price, category_id, description, image_url, stock, featured, color) 
VALUES  ('Smartphone', 499.99, 1, 'A powerful and feature-rich smartphone for all your communication needs.', 'smartphone.jpg', 50, 0, 'Black'),
        ('Laptop', 899.99, 1, 'A high-performance laptop for work and entertainment.', 'laptop.jpg', 30, 0, 'Gray'),
        ('Headphones', 99.99, 1, 'Immerse yourself in music with these high-quality headphones.', 'headphones.jpg', 100, 1, 'White'),
        ('Smart TV', 1499.99, 1, 'Experience stunning visuals and smart features with this advanced television.', 'smart-tv.jpg', 20, 0, 'Black'),
        ('Digital Camera', 599.99, 1, 'Capture life''s precious moments with this professional-grade digital camera.', 'camera.jpg', 15, 1, 'Silver'),
        ('Tablet', 349.99, 1, 'A portable and versatile tablet for productivity and entertainment.', 'tablet.jpg', 40, 0, 'Black'),
        ('Gaming Console', 399.99, 1, 'Experience the latest gaming adventures with this powerful gaming console.', 'gaming-console.jpg', 10, 0, 'Black'),
        ('Wireless Earbuds', 79.99, 1, 'Enjoy wireless freedom and crystal-clear audio with these sleek earbuds.', 'earbuds.jpg', 75, 0, 'White'),
        ('Smart Watch', 199.99, 1, 'Stay connected and track your fitness goals with this stylish smartwatch.', 'smartwatch.jpg', 25, 1, 'White'),
        ('Bluetooth Speaker', 129.99, 1, 'Take your music anywhere with this portable and high-quality Bluetooth speaker.', 'speaker.jpg', 50, 0, 'Charcoal'),
        ('Drones', 299.99, 1, 'Explore the skies and capture breathtaking aerial photos and videos with this drone.', 'drone.jpg', 5, 0, 'White'),
        ('Printer', 149.99, 1, 'Print documents and photos with ease using this reliable printer.', 'printer.jpg', 20, 0, 'White'),
        ('Fitness Tracker', 89.99, 1, 'Monitor your fitness activities and achieve your health goals with this fitness tracker.', 'fitness-tracker.jpg', 30, 1, 'Charcoal'),
        ('Wireless Router', 79.99, 1, 'Ensure fast and reliable internet connectivity with this high-performance wireless router.', 'wireless-router.jpg', 15, 0, 'Black'),
        ('External Hard Drive', 129.99, 1, 'Expand your storage capacity and backup your important files with this external hard drive.', 'external-hard-drive.jpg', 25, 1, 'Gray'),
        ('Gaming Keyboard', 79.99, 1, 'Enhance your gaming experience with this responsive and customizable gaming keyboard.', 'gaming-keyboard.jpg', 35, 1, 'Black'),
        ('Virtual Reality Headset', 299.99, 1, 'Immerse yourself in virtual worlds with this cutting-edge virtual reality headset.', 'vr-headset.jpg', 10, 0, 'Charcoal'),
        ('Wireless Mouse', 49.99, 1, 'Navigate your computer with precision and freedom using this wireless mouse.', 'wireless-mouse.jpg', 50, 1, 'Charcoal'),
        ('Smart Home Hub', 179.99, 1, 'Control your smart devices and create a connected home with this intelligent home hub.', 'smart-home-hub.jpg', 10, 0, 'White'),
        ('Portable Charger', 39.99, 1, 'Keep your devices powered up on the go with this compact and reliable portable charger.', 'portable-charger.jpg', 50, 0, 'Black');
-- mens clothes
INSERT INTO products (name, price, category_id, description, image_url, stock, featured, color) 
VALUES  ('Men''s T-Shirt', 29.99, 2, 'A comfortable and stylish t-shirt for everyday wear.', 'mens-tshirt.jpg', 50, 1, 'Charcoal'),
        ('Men''s Jeans', 59.99, 2, 'Classic denim jeans for a timeless and casual look.', 'mens-jeans.jpg', 30, 0, 'Blue'),
        ('Men''s Dress Shirt', 49.99, 2, 'A sophisticated dress shirt for formal occasions.', 'mens-dress-shirt.jpg', 40, 0, 'White'),
        ('Men''s Hoodie', 39.99, 2, 'Stay warm and stylish with this cozy hoodie.', 'mens-hoodie.jpg', 25, 1, 'Black'),
        ('Men''s Suit', 199.99, 2, 'Look sharp and elegant with this tailored suit.', 'mens-suit.jpg', 10, 0, 'Dark Blue'),
        ('Men''s Shorts', 34.99, 2, 'Comfortable and versatile shorts for a relaxed summer look.', 'mens-shorts.jpg', 30, 0, 'Tan'),
        ('Men''s Sweater', 59.99, 2, 'Stay cozy and fashionable with this stylish sweater.', 'mens-sweater.jpg', 20, 0, 'Brown'),
        ('Men''s Polo Shirt', 39.99, 2, 'A classic and versatile polo shirt for a smart-casual style.', 'mens-polo-shirt.jpg', 50, 1, 'Olive'),
        ('Men''s Jacket', 79.99, 2, 'A trendy and functional jacket for all seasons.', 'mens-jacket.jpg', 15, 1, 'Charcoal'),
        ('Men''s Dress Shoes', 89.99, 2, 'Elevate your formal look with these stylish dress shoes.', 'mens-dress-shoes.jpg', 25, 0, 'Brown'),
        ('Men''s Sneakers', 69.99, 2, 'Comfortable and stylish sneakers for everyday wear.', 'mens-sneakers.jpg', 50, 1, 'White'),
        ('Men''s Watch', 149.99, 2, 'A sophisticated and elegant watch to complete your look.', 'mens-watch.jpg', 20, 1, 'Black'),
        ('Men''s Belt', 29.99, 2, 'A versatile and stylish belt to enhance your outfit.', 'mens-belt.jpg', 35, 0, 'Brown'),
        ('Men''s Socks', 9.99, 2, 'High-quality and comfortable socks for everyday use.', 'mens-socks.jpg', 100, 1, 'Turquoise'),
        ('Men''s Swim Trunks', 34.99, 2, 'Stylish and comfortable swim trunks for beach and pool days.', 'mens-swim-trunks.jpg', 30, 0, 'Orange'),
        ('Men''s Winter Coat', 149.99, 2, 'Stay warm and fashionable during the winter season with this coat.', 'mens-winter-coat.jpg', 10, 0, 'Red'),
        ('Men''s Hat', 24.99, 2, 'Add a stylish touch to your outfit with this fashionable hat.', 'mens-hat.jpg', 50, 1, 'Navy'),
        ('Men''s Tie', 19.99, 2, 'Complete your formal look with this elegant and classy tie.', 'mens-tie.jpg', 40, 0, 'Orange'),
        ('Men''s Dress Pants', 49.99, 2, 'A pair of tailored dress pants for a polished and professional look.', 'mens-dress-pants.jpg', 20, 0, 'Khaki'),
        ('Men''s Casual Shirt', 39.99, 2, 'A versatile and comfortable shirt for a laid-back style.', 'mens-casual-shirt.jpg', 30, 1, 'Gray');
-- womens clothes
INSERT INTO products (name, price, category_id, description, image_url, stock, featured, color) 
VALUES  ('Women''s Dress', 79.99, 2, 'A beautiful and elegant dress for special occasions.', 'womens-dress.jpg', 50, 0, 'Mint'),
        ('Women''s Jeans', 69.99, 2, 'Comfortable and stylish jeans for a fashionable look.', 'womens-jeans.jpg', 30, 1, 'Blue'),
        ('Women''s Blouse', 49.99, 2, 'A versatile and chic blouse for everyday wear.', 'womens-blouse.jpg', 40, 0, 'Lavender'),
        ('Women''s Sweater', 59.99, 2, 'Stay cozy and fashionable with this stylish sweater.', 'womens-sweater.jpg', 25, 1, 'Teal'),
        ('Women''s Skirt', 39.99, 2, 'A trendy and versatile skirt for a feminine look.', 'womens-skirt.jpg', 10, 0, 'Gray'),
        ('Women''s Shorts', 34.99, 2, 'Comfortable and stylish shorts for a casual summer look.', 'womens-shorts.jpg', 30, 1, 'Blue'),
        ('Women''s Jumpsuit', 89.99, 2, 'A fashionable and effortless jumpsuit for a trendy look.', 'womens-jumpsuit.jpg', 20, 0, 'Maroon'),
        ('Women''s T-Shirt', 29.99, 2, 'A comfortable and stylish t-shirt for everyday wear.', 'womens-tshirt.jpg', 50, 0, 'Mint'),
        ('Women''s Blazer', 89.99, 2, 'A sophisticated and tailored blazer for a polished look.', 'womens-blazer.jpg', 15, 1, 'Maroon'),
        ('Women''s Activewear Set', 79.99, 2, 'Stay active and stylish with this matching activewear set.', 'womens-activewear.jpg', 25, 0, 'Lavender'),
        ('Women''s Swimwear', 59.99, 2, 'Stylish and comfortable swimwear for beach and pool days.', 'womens-swimwear.jpg', 50, 0, 'Yellow'),
        ('Women''s Shoes', 79.99, 2, 'Step out in style with these fashionable and comfortable shoes.', 'womens-shoes.jpg', 35, 1, 'Red'),
        ('Women''s Hat', 29.99, 2, 'Add a stylish touch to your look with this fashionable hat.', 'womens-hat.jpg', 100, 1, 'Orange'),
        ('Women''s Socks', 9.99, 2, 'Comfortable and stylish socks for everyday use.', 'womens-socks.jpg', 30, 1, 'Teal'),
        ('Women''s Winter Coat', 149.99, 2, 'Stay warm and fashionable during the winter season with this coat.', 'womens-winter-coat.jpg', 10, 0, 'Pink'),
        ('Women''s Scarf', 24.99, 2, 'A versatile and cozy scarf to add a pop of color to your outfit.', 'womens-scarf.jpg', 50, 0, 'Maroon'),
        ('Women''s Formal Gown', 199.99, 2, 'A stunning and glamorous gown for formal events.', 'womens-gown.jpg', 30, 1, 'Burgundy');
-- home & kitchen
INSERT INTO products (name, price, category_id, description, image_url, stock, featured, color) 
VALUES  ('Cookware Set', 149.99, 3, 'A comprehensive set of high-quality cookware for all your culinary needs.', 'cookware-set.jpg', 50, 1, 'Red'),
        ('Coffee Maker', 79.99, 3, 'Brew your favorite coffee with this efficient and stylish coffee maker.', 'coffee-maker.jpg', 30, 0, 'Black'),
        ('Kitchen Knife Set', 59.99, 3, 'A set of sharp and durable knives for effortless food preparation.', 'knife-set.jpg', 40, 1, 'Silver'),
        ('Food Processor', 99.99, 3, 'Make food preparation easier and faster with this versatile food processor.', 'food-processor.jpg', 25, 0, 'Silver'),
        ('Blender', 49.99, 3, 'Blend smoothies, soups, and more with this powerful and reliable blender.', 'blender.jpg', 10, 1, 'Black'),
        ('Air Fryer', 89.99, 3, 'Enjoy crispy and delicious fried foods with less oil using this convenient air fryer.', 'air-fryer.jpg', 30, 0, 'Red'),
        ('Toaster', 39.99, 3, 'A reliable and efficient toaster for perfectly toasted bread and bagels.', 'toaster.jpg', 20, 1, 'Silver'),
        ('Slow Cooker', 69.99, 3, 'Prepare flavorful and tender meals with this convenient slow cooker.', 'slow-cooker.jpg', 50, 1, 'Blue'),
        ('Electric Kettle', 29.99, 3, 'Boil water quickly and efficiently with this sleek electric kettle.', 'electric-kettle.jpg', 15, 0, 'Silver'),
        ('Microwave Oven', 99.99, 3, 'Heat and cook food with ease using this versatile microwave oven.', 'microwave-oven.jpg', 25, 0, 'Silver'),
        ('Food Storage Containers', 24.99, 3, 'Keep your food fresh and organized with this set of reusable storage containers.', 'food-storage-containers.jpg', 50, 0, 'White'),
        ('Utensil Set', 19.99, 3, 'A comprehensive set of cooking utensils for all your kitchen needs.', 'utensil-set.jpg', 35, 1, 'Silver'),
        ('Dining Set', 149.99, 3, 'Elevate your dining experience with this elegant and durable dining set.', 'dining-set.jpg', 25, 0, 'Red'),
        ('Casserole Dish', 34.99, 3, 'Bake and serve delicious casseroles with this versatile and stylish dish.', 'casserole-dish.jpg', 50, 0, 'White'),
        ('Cutting Board Set', 29.99, 3, 'A set of durable and hygienic cutting boards for all your food preparation.', 'cutting-board-set.jpg', 10, 0, 'Gray'),
        ('Canister Set', 49.99, 3, 'Store and organize your kitchen essentials with this stylish canister set.', 'canister-set.jpg', 20, 0, 'Blue'),
        ('Glassware Set', 39.99, 3, 'Enjoy your favorite beverages in style with this set of elegant glassware.', 'glassware-set.jpg', 35, 0, 'Clear'),
        ('Bakeware Set', 79.99, 3, 'A versatile set of baking pans and trays for all your baking needs.', 'bakeware-set.jpg', 10, 1, 'White'),
        ('Electric Mixer', 59.99, 3, 'Mix ingredients effortlessly with this powerful and handy electric mixer.', 'electric-mixer.jpg', 30, 1, 'Silver'),
        ('Ice Cream Maker', 49.99, 3, 'Make delicious homemade ice cream with this easy-to-use ice cream maker.', 'ice-cream-maker.jpg', 25, 1, 'Black'),
        ('Serving Tray', 19.99, 3, 'Serve your favorite dishes and snacks with style using this elegant serving tray.', 'serving-tray.jpg', 50, 0, 'Tan'),
        ('Spice Rack', 24.99, 3, 'Organize and display your spices with this convenient and space-saving spice rack.', 'spice-rack.jpg', 30, 1, 'White'),
        ('Kitchen Scale', 14.99, 3, 'Accurately measure ingredients for your recipes with this reliable kitchen scale.', 'kitchen-scale.jpg', 25, 0, 'Silver'),
        ('Tea Kettle', 29.99, 3, 'Brew a perfect cup of tea with this classic and durable tea kettle.', 'tea-kettle.jpg', 50, 1, 'White'),
        ('Wine Glasses', 29.99, 3, 'Sip and savor your favorite wines with these elegant wine glasses.', 'wine-glasses.jpg', 15, 1, 'Clear'),
        ('Dish Rack', 34.99, 3, 'Dry and organize your dishes with this practical and space-saving dish rack.', 'dish-rack.jpg', 25, 0, 'Gray'),
        ('Apron', 19.99, 3, 'Protect your clothes while cooking with this stylish and functional apron.', 'apron.jpg', 35, 0, 'White'),
        ('Kitchen Timer', 9.99, 3, 'Keep track of cooking times with this handy and easy-to-use kitchen timer.', 'kitchen-timer.jpg', 100, 0, 'White'),
        ('Mixing Bowls Set', 29.99, 3, 'A set of versatile and durable mixing bowls for all your culinary creations.', 'mixing-bowls.jpg', 30, 1, 'Silver'),
        ('Measuring Cup Set', 14.99, 3, 'Accurately measure ingredients with this set of handy and stackable measuring cups.', 'measuring-cups.jpg', 50, 1, 'Green');

-- sample duplicates from "bug"
INSERT INTO products (name, price, category_id, description, image_url, stock, featured, color)
VALUES  ('Laptop', 999.99, 1, 'A high-performance laptop for work and entertainment.', 'laptop.jpg', 30, 0, 'Gray'),
        ('Laptop', 999.99, 1, 'A high-performance gaming laptop.', 'laptop.jpg', 30, 0, 'Gray'),
        ('Tea Kettle', 29.99, 3, 'Brew a perfect cup of tea with this classic tea kettle.', 'tea-kettle.jpg', 50, 1, 'White');

-- add shopping cart items
INSERT INTO shopping_cart (user_id, product_id, quantity)
VALUES  (3, 8, 1),
        (3, 10, 1);
