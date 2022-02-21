# Product


## Экран «Main»
**API:**<br/>
**GET** - https://shopapi-0575.restdb.io/rest/home<br/>
**Header** - x-apikey: 61ddae2e95cb716ea5ee48e4

### Общие требования:

**Select Category** - При нажатию на иконку она меняет цвет (как по дизайну)<br/>
Выбрана и выделенная иконка может быть только одна.

**Hot sales** - карусель при свайпе вправо меняет элемент<br/>
● Изображение;<br/>
● Метка New, появляется только на новых товарах;<br/>
● Бренд товара;<br/>
● Краткое описание;<br/>
● Кнопка купить;

**Best Seller** - Список товара имеет следующие параметры:<br/>
● Название;<br/>
● Изображение;<br/>
● Цену за шт.: цена с учетом скидки ;<br/>
● Цену за шт.: цена без учета скидки ;<br/>
● Добавить в избранное ;

**Filter options** - раскрывающийся список бренда и размера, диапазон цен от 0 до 10000$<br/>
Фильтр открывается по нажатии на кнопку в правом верхнем углу<br/>
● Brand<br/>
● Price<br/>
● Size


## Экран  «Product Details»
**API:** ( пример только по одной модели телефона)<br/>
**GET** - https://shopapi-0575.restdb.io/rest/detail<br/>
**Header** - x-apikey: 61ddae2e95cb716ea5ee48e4

Общие требования:

● Изображение - карусель при свайпе вправо меняет элемент;<br/>
● Название;<br/>
● Метка favorites;<br/>
● Рейтинг товара;<br/>
● Цвет товара;<br/>
● Детали товара;<br/>
● Характеристика;<br/>
● Добавить в корзину;


## Экран «My Cart»
**API:**<br/>
**GET** - https://shopapi-0575.restdb.io/rest/cart<br/>
**Header** - x-apikey: 61ddae2e95cb716ea5ee48e4

**Функционал**<br/>
1)Пользователь видит в тапбаре иконку корзины.<br/>
2)Пользователь может перейти в корзину при нажатии на иконку Корзины в тапбаре.


Пользователь видит список добавленных товаров в корзине.<br/>
Каждый товар в списке имеет следующие параметры:<br/>
●  	Название;<br/>
●  	Изображение;<br/>
●  	Цену за шт.: цена с учетом скидки;<br/>
●  	Итоговую цену с учетом количества - данного товара, добавленного в корзину;<br/>
●   Стоимость доставки;
