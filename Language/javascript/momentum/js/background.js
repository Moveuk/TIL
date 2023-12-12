const images = [
  "https://p4.wallpaperbetter.com/wallpaper/945/816/959/rik-oostenbroek-abstract-hd-wallpaper-preview.jpg",
  "https://p4.wallpaperbetter.com/wallpaper/755/222/407/rik-oostenbroek-simple-background-face-digital-art-wallpaper-preview.jpg",
  "https://p4.wallpaperbetter.com/wallpaper/204/759/755/artwork-digital-art-abstract-simple-background-wallpaper-preview.jpg",
  "https://p4.wallpaperbetter.com/wallpaper/569/904/1007/abstract-rik-oostenbroek-digital-art-artwork-wallpaper-preview.jpg",
  "https://p4.wallpaperbetter.com/wallpaper/967/867/776/abstract-brain-science-artwork-wallpaper-preview.jpg",
  "https://p4.wallpaperbetter.com/wallpaper/219/271/829/abstract-lines-colorful-simple-wallpaper-preview.jpg",
  "https://p4.wallpaperbetter.com/wallpaper/473/135/798/digital-art-minimalism-simple-background-dots-wallpaper-preview.jpg",
  "https://p4.wallpaperbetter.com/wallpaper/314/561/208/5bd28efa2eb6a-wallpaper-preview.jpg",
];

const chosenImage = images[Math.floor(Math.random() * images.length)];

const bgImage = document.createElement("img");

bgImage.src = chosenImage;

document.body.appendChild(bgImage);
