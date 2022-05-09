package pl.javastart.devicrent.components.device;

class CategoryNotFoundException extends RuntimeException {
    CategoryNotFoundException(String message) {
        super(message);
    }
}