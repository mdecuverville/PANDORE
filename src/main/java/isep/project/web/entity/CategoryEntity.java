package isep.project.web.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by owner on 18-05-07.
 */
@Entity
@Table(name = "categories", schema = "heroku_9efd0238a94d992")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private int id;

    @Basic
    @Column(name = "category_name", nullable = true, length = 45)
    private String categoryName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinTable(
            name = "users_groups_categories",
            joinColumns = @JoinColumn(name = "categories_id"),
            inverseJoinColumns = @JoinColumn(name = "users_groups_id")
    )
    private List<UserGroupEntity> usersGroups;

    public CategoryEntity() {
        this.setUsersGroups(new LinkedList<UserGroupEntity>());
    }

    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<UserGroupEntity> getUsersGroups() {
        return usersGroups;
    }

    public void setUsersGroups(List<UserGroupEntity> usersGroups) {
        this.usersGroups = usersGroups;
    }

    public void addUserGroup(UserGroupEntity usersGroup) {
        if (usersGroups == null) {
            usersGroups = new LinkedList<>();
        }

        usersGroups.add(usersGroup);
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", usersGroups=" + usersGroups +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return id == that.id &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(usersGroups, that.usersGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, usersGroups);
    }
}
