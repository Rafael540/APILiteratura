package rafael.literatura.model;


import jakarta.persistence.*;

@Entity
@Table(name="livro")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    private Author autor;

    private String sumaries;

    private String editors;

    @Enumerated(EnumType.STRING)
    private Idioma idioma;

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(String bookshelves) {
        this.bookshelves = bookshelves;
    }

    public Idioma getTranslate() {
        return translate;
    }

    public void setTranslate(Idioma translate) {
        this.translate = translate;
    }

    private String subjects;
    private String bookshelves;

    private Idioma translate;


    public Book(DadosLivros dados) {
        this.title = dados.title();
        this.sumaries = dados.sumaries();
        this.editors = dados.editors();
        this.subjects = dados.subjects();
        this.bookshelves = dados.bookshelves();
    }

    public String getSumaries() {
        return sumaries;
    }

    public void setSumaries(String sumaries) {
        this.sumaries = sumaries;
    }

    public String getEditors() {
        return editors;
    }

    public void setEditors(String editors) {
        this.editors = editors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autor=" + autor +
                ", sumaries='" + sumaries + '\'' +
                ", editors='" + editors + '\'' +
                ", idioma=" + idioma +
                ", subjects='" + subjects + '\'' +
                ", bookshelves='" + bookshelves + '\'' +
                ", translate=" + translate +
                '}';
    }
}
